package com.hengyunsoft.security.gete.filter;

import com.hengyunsoft.platform.developer.api.service.dto.module.ModuleUseJnlSaveDTO;
import com.hengyunsoft.security.gete.config.GateIgnoreProperties;
import com.hengyunsoft.security.gete.jobs.ModuleUseJnlCrontab;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;

/**
 * admin 功能统计日志记录过滤器
 *
 * @author sxy
 * @createTime 2018-4-23
 */
@Component
@Slf4j
public class ModuleUseJnlFilter extends ZuulFilter {

    /**
     * 为zuul设置一个公共的前缀
     */
    @Value("${server.context-path}")
    private String zuulPrefix;

    @Autowired
    private GateIgnoreProperties gateIgnoreProperties;

    @SuppressWarnings("rawtypes")
    @Resource(name = "redisJdkTemplate")
    private  RedisTemplate redisTemplate;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    /**
     * 给 userService 接口添加拦截器，每次调用userService 接口的方法，都自动在请求头中添加
     * auth-client-token 和 auth-user-token
     */
    @PostConstruct
    public void init() {
    }

    /**
     * pre：可以在请求被路由之前调用
     * route：在路由请求时候被调用
     * post：在route和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        // 前置过滤器
        return "post";
    }

    /**
     * filterOrder：通过int值来定义过滤器的执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        // 优先级为1，数字越大，优先级越低
        return 100;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
    	RequestContext ctx = RequestContext.getCurrentContext();
        log.info("服务调用统计功能------------------>[{}][{}][{}]",ctx.get(AdminAccessFilter.CONSUMER_MODULE_ID_KEY),ctx.sendZuulResponse(),ctx.getThrowable());
		return ctx.getThrowable() == null && ctx.sendZuulResponse() && ctx.get(AdminAccessFilter.CONSUMER_MODULE_ID_KEY) != null;
        //return true; //测试使用
    }

    /**
     * 过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，
     * 不对其进行路由，然后通过ctx.setResponseStatusCode(200)设置了其返回的错误码
     *
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String consumerAppId = null;
        String consumerModuleId = null;
        log.info("统计功能调用开始!!");

        //redis不存在
        if(redisTemplate == null){
            log.info("放入缓存功能调用信息开始,redis服务不存在!!");
            return null;
        }
        try {
            HttpServletRequest request = ctx.getRequest();
            // 不进行拦截的地址
            final String requestUri = request.getRequestURI().substring(zuulPrefix.length());
            if (isStartWith(requestUri)) {
                return null;
            }
            
            //获取返回的状态码
            int responseSatusCode = ctx.getResponseStatusCode();
            ModuleUseJnlSaveDTO dto = new ModuleUseJnlSaveDTO();
            consumerAppId = (String) ctx.get(AdminAccessFilter.CONSUMER_APP_ID_KEY);
            Long consumerModuleIdLong = (Long) ctx.get(AdminAccessFilter.CONSUMER_MODULE_ID_KEY);
            if(consumerModuleIdLong != null) {
            	consumerModuleId = consumerModuleIdLong.toString();
            }
            dto.setAppId(consumerAppId);
            //consumerModuleId = String.valueOf(getRandom()); //测试使用
            dto.setModuleId(consumerModuleId);
            dto.setTotalNum(1);

            //响应状态码小于400均为成功
            dto.setErrorNum(responseSatusCode<400?0:1);

            //将DTO放入缓存中
            String redisKey = keyPrefix + ":" + consumerAppId +"_"+ consumerModuleId;

            //根据当前key获取缓存数据
            ConcurrentHashMap<String,Object> cacheMap  = (ConcurrentHashMap<String,Object>)
                    redisTemplate.opsForValue().get(keyPrefix + ":" + ModuleUseJnlCrontab.MODULE_USE_JNL_CACHE);
            ModuleUseJnlSaveDTO cacheDto = null;
            if(cacheMap != null){
                cacheDto = (ModuleUseJnlSaveDTO)cacheMap.get(redisKey);
            }else{
                cacheMap = new ConcurrentHashMap<String,Object>();
            }

            //判断是否存在存在历史缓存
            if(cacheDto!=null){
                cacheDto.setTotalNum(cacheDto.getTotalNum()+dto.getTotalNum());
                cacheDto.setErrorNum(cacheDto.getErrorNum()+dto.getErrorNum());
                set(redisKey,cacheDto,cacheMap);//存在key
            }else{
                set(redisKey,dto,cacheMap);//第一次放入
            }
            log.info("统计功能调用成功,应用ID[{}],模块ID[{}]",consumerAppId,consumerModuleId);
        } catch (Exception e) {
            log.info("统计功能调用异常,应用ID[{}],模块ID[{}]",consumerAppId,consumerModuleId,e);
        } 
        return null;
    }

    /**
     * 获取随机数 20 - 50
     * 测试使用
     * @param
     * @return
     */
    private int getRandom(){
        //int [] arr = {20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
        int [] arr = {20,21,22,23,24};
        //产生0-(arr.length-1)的整数值,也是数组的索引
        int index = (int)(Math.random()*arr.length);
        return arr[index];
    }

    /**
     * 放入缓存
     * @param redisKey
     * @param dto
     * @param map
     */
    private void set(String redisKey,ModuleUseJnlSaveDTO dto,ConcurrentHashMap<String,Object> map){
        map.put(redisKey,dto);
        redisTemplate.opsForValue().set(keyPrefix + ":" + ModuleUseJnlCrontab.MODULE_USE_JNL_CACHE,map);//缓存
    }

    /**
     * URI是否以什么打头
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        if (gateIgnoreProperties == null || gateIgnoreProperties.getStartWithList().isEmpty()) {
            return flag;
        }
        for (String s : gateIgnoreProperties.getStartWithList()) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }
}

