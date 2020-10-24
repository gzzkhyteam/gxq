package com.hengyunsoft.zipkin.api.ext;

import static zipkin.internal.Util.UTF_8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zipkin.Codec;
import zipkin.storage.StorageComponent;

@RestController
@RequestMapping("ext")
public class ZipkinQueryApiExt {

	/** Logger available to subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private final StorageComponent storage;

   @Autowired
   public ZipkinQueryApiExt(StorageComponent storage) {
      this.storage = storage; // don't cache spanStore here as it can cause the app to crash!
   }

	@PostConstruct
	public void init() {

		jdbcTemplate = new JdbcTemplate(dataSource, true);
	}

	/**
	 * 
	 * @param serviceName     服务名称    网关及网关内的所有应用
	 * @param appId           应用appid  面向于用户的所有应用（比如：权限管理系统，服务监控系统）
	 * @param minDuration     最小持续时间（请求最小耗时） 秒
	 * @param maxDuration     最大持续时间（请求最大耗时） 秒
	 * @param startTs         筛选时间段（开始时间）        yyyy-MM-dd HH:mm:ss
	 * @param endTs           筛选时间段（结束时间）        yyyy-MM-dd HH:mm:ss
	 * @param page            分页参数页                      1开始
	 * @param limit           大小
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/rootTraces", method = RequestMethod.GET)
	public Map<String, Object> getTraces(
			@RequestParam(value = "serviceName", required = false) String serviceName,
			@RequestParam(value = "appId", required = false) String appId,
			@RequestParam(value = "minDuration", required = false) Long minDuration,
			@RequestParam(value = "maxDuration", required = false) Long maxDuration,
			@RequestParam(value = "startTs", required = false) String startTs,
			@RequestParam(value = "endTs", required = false) String endTs, 
			Integer pageNo,
			Integer pageSize) throws ParseException {
		
		List<Object> args = new ArrayList<>(10);
		
		Long start = dateToLong(startTs);
		Long end = dateToLong(endTs);
		minDuration = minDuration == null? null : minDuration*1000;
		maxDuration = maxDuration == null? null : maxDuration*1000;
		String sql = builderQuerySql(serviceName, appId, minDuration, maxDuration, start, end, args);
		String dateSqlquery = sql + " desc limit ?,? ";
		String dateSqlcount = "select count(*) from (" +sql + ") tempTable ";
		Integer totalRowNums = jdbcTemplate.queryForObject(dateSqlcount, Integer.class, args.toArray());
		List<TraceDTO> data = null ;
		if(totalRowNums > 0) {
			args.add((pageNo-1)*pageSize);
			args.add(pageSize);
			data = jdbcTemplate.query(dateSqlquery, args.toArray(), new BeanPropertyRowMapper(TraceDTO.class));
		}
		Map<String,Object> result = new HashMap<>();
		result.put("pages", (totalRowNums-1)/pageSize+1);
		result.put("total", totalRowNums);
		result.put("list", data);
		return result;
	}

	private synchronized Long dateToLong(String date) throws ParseException {
		
		if(StringUtils.isEmpty(date)) {
			return null;
		}
		return dateFormat.parse(date).getTime();
	}

	private String builderQuerySql(String serviceName, String appId, Long minDuration, Long maxDuration, Long startTs,
			Long endTs,  List<Object> args) {

		StringBuilder sql = new StringBuilder(200);
		sql.append("select zipkin_spans.id traceId,zipkin_spans.name name,zipkin_spans.start_ts `start`,zipkin_spans.duration duration ,zipkin_annotations.a_value appId,zipkin_annotations.endpoint_service_name endpointServiceName ");
		sql.append(" from zipkin_spans  join zipkin_annotations on zipkin_spans.id = zipkin_annotations.span_id and zipkin_annotations.a_key = 'app_id' ");
		
		if(!StringUtils.isEmpty(appId) && !StringUtils.isEmpty(serviceName)) {
			sql.append(" and zipkin_annotations.a_value = ? ");
			args.add(appId + "@" + serviceName);
		} else if (!StringUtils.isEmpty(appId)) {
			sql.append(" and zipkin_annotations.a_value like ? ");
			args.add(appId + "@%");
		} else if (!StringUtils.isEmpty(serviceName)) {
			sql.append(" and zipkin_annotations.a_value like ? ");
			args.add("%@"+serviceName);
		}
		
		sql.append(" where 	zipkin_spans.trace_id = zipkin_spans.id ");
//		if(serviceName != null && serviceName.length() >0) {
//			//sql.append(" and zipkin_spans.trace_id in ( 	 select cc.trace_id from zipkin_annotations cc  where cc.endpoint_service_name = ?)");
//			sql.append(" and zipkin_annotations.endpoint_service_name = ?");
//			args.add(serviceName);
//		}
		if(minDuration != null) {
			sql.append(" and zipkin_spans.duration >= ?");
			args.add(minDuration);
		}
		if(maxDuration != null) {
			sql.append(" and zipkin_spans.duration <= ?");
			args.add(maxDuration);
		}
		if(startTs != null) {
			sql.append(" and zipkin_spans.start_ts >= ?");
			args.add(startTs*1000);
		}
		if(endTs != null) {
			sql.append(" and zipkin_spans.start_ts <= ?");
			args.add(endTs*1000);
		}
		
		sql.append(" order by  start_ts ");

		return sql.toString();
	}
	
	
  @RequestMapping(value = "/trace/{traceId}", method = RequestMethod.GET)
  public String getTrace(@PathVariable("traceId") Long traceId) {
    return new String(Codec.JSON.writeSpans(storage.spanStore().getTrace(0,traceId)), UTF_8);
  }
}
