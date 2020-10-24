package com.hengyunsoft.platform.search.manager;

import com.hengyunsoft.commons.exception.core.SearchException;
import com.hengyunsoft.exception.BizException;
import com.hengyunsoft.platform.search.dto.IndexItemDTO;
import com.hengyunsoft.platform.search.dto.IndexItemResDTO;
import com.hengyunsoft.platform.search.dto.SeacherParamDTO;
import com.hengyunsoft.platform.search.dto.SearchResDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.request.FieldAnalysisRequest;
import org.apache.solr.client.solrj.response.FieldAnalysisResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SearchManager {
    @Autowired
    private HengYunSolr solrClient;

    /**
     * 标题
     */
    public static final String INDEX_TITLE = "title";

    /**
     * 内容
     */
    public static final String INDEX_CONTENT = "content";

    /**
     * 标题致前权重
     */
    public static final String INDEX_TITLE_WEIGHT = "^2";

    /**
     * 内容致前权重
     */
    public static final String INDEX_CONTENT_WEIGHT = "^0.1";

    /***
     * 创建或者更新索引
     * @param collCode
     * @param item
     * @throws Exception
     */
    public void addOrUpdateIndex(String collCode, IndexItemDTO item) throws Exception {
        solrClient.addBean(collCode, item);
        //TODO 后面要改成不显示提交，配置满足条件自动提交
        solrClient.commit(collCode);
    }

    /**
     * 处理搜索参数
     * @param qParam
     * @param appendCondition
     * @return
     */
    public  String handleParams(String qParam,String appendCondition){
        String temp = null;
        String arrs[] = appendCondition.split(",");
        for(int i=0;i<arrs.length;i++){
            if(i==0){
                temp = qParam + " AND type:" + arrs[i];
            }else{
                if(i==1){
                    temp = "("+temp+")";
                }
                temp += " OR "+"("+qParam + " AND type:" + arrs[i]+")";
            }
        }
        return temp;
    }

    /***
     * 执行搜索
     * @param param
     * @return
     * @throws Exception
     */
    public SearchResDTO addSearch(SeacherParamDTO param) throws Exception {
        // SolrClient client = getSolrClient();
        int startNum = (param.getPageNo() - 1) * param.getPageSize();
        String qParam = "(" + INDEX_CONTENT + ":" + param.getKeyWords() + INDEX_CONTENT_WEIGHT + " OR " + INDEX_TITLE + ":" + param.getKeyWords() + INDEX_TITLE_WEIGHT +")";
        //String qParam = "(" + INDEX_CONTENT + ":" + param.getKeyWords() + " OR " + INDEX_TITLE + ":" + param.getKeyWords() + ")";

        if (StringUtils.isNotEmpty(param.getReplaceCondition())) {
            qParam = param.getReplaceCondition();
        } else if (StringUtils.isNotEmpty(param.getAppendCondition())) {
            //qParam += param.getAppendCondition();
            qParam = handleParams(qParam,param.getAppendCondition());
        }
        log.info("查询参数为：qParam[{}]",qParam);
        SolrQuery query = new SolrQuery();
        query.set("collection", param.getCollections());
        query.setQuery(qParam);
        query.setStart(startNum);
        query.setRows(param.getPageSize());
        //query.addSort("ext", SolrQuery.ORDER.desc);//时间降序排序,会对关键词搜索的匹配返回结果顺序有一定影响。
        query.setHighlight(param.isHighlighter());//高亮显示设置
        query.setHighlightSimplePre("<span class='highlightsimple' style='color: red;font-weight: bold'>");
        query.setHighlightSimplePost("</span>");
        query.setHighlightSnippets(1);//结果分片数，默认为1
        query.setHighlightFragsize(100);//每个分片的最大长度，默认为100
        query.setParam("hl.fl", INDEX_TITLE, INDEX_CONTENT);
        String collection = param.getCollections().split(",")[0];
        QueryResponse response = solrClient.query(collection, query);

        //命中的总条数
        long numFound = response.getResults().getNumFound();

        List<IndexItemResDTO> beans = response.getBeans(IndexItemResDTO.class);
        Map<String, Map<String, List<String>>> highlightingRes = response.getHighlighting();
        SearchResDTO res = new SearchResDTO();
        for (IndexItemResDTO item : beans) {
            Map<String, List<String>> stringListMap = highlightingRes.get(item.getId());
            res.addResItem(item, stringListMap);
        }
        res.setPageNo(param.getPageNo());
        res.setPageSize(param.getPageSize());
        res.setTotal(numFound);
        res.setDatas(handleDatas(res.getDatas(),param.getKeyWords()));
        return res;
    }

    /**
     * 处理搜索返回数据
     * 将完全匹配的放在前面，在按时间由近到远排序
     * @param datas
     * @param keywords
     * @return
     */
    public List<IndexItemResDTO> handleDatas(List<IndexItemResDTO> datas,String keywords){
        List<IndexItemResDTO> firstList = new ArrayList<>();
        List<IndexItemResDTO> secondList = new ArrayList<>();
        if(datas==null){
            return null;
        }
        for(IndexItemResDTO data:datas){
            if(keywords.equals(data.getTitle())){
                firstList.add(data);
            }else{
                secondList.add(data);
            }
        }
        firstList.addAll(secondList);
        return firstList;
    }

    /***
     * 创建集合
     * @param collectionName
     * @throws Exception
     */
    public void createCollection(String collectionName) throws Exception {
        //SolrClient client = getSolrClient();
        //通过URL创建collection需要满足条件：num of (shards + replications)< num of live nodes
        //索引这边numShards,numReplicas不可控，那么只能默认都是numShards=3， replications=2两个副本，
        //如果创建失败,说明solr存活几点比较少，必须检查启动节点
        //只有不抛出异常就一定创建成功了，即使是集合已经存在也会抛出异常
        CollectionAdminRequest.Create create = CollectionAdminRequest.createCollection(collectionName, "_default", solrClient.getNumShards(), solrClient.getNumReplicas());
        solrClient.request(create);
    }

    /***
     * 关键字分析
     * @throws Exception
     */
    /***
     *
     * @param keyWord
     * @param collection
     * @param field title(标题)，content(内容)
     * @return
     * @throws Exception
     */
    public FieldAnalysisResponse analysisField(String keyWord, String queryWord, String collection, String field) throws Exception {
        FieldAnalysisRequest analysisRequest = new FieldAnalysisRequest();
        analysisRequest.addFieldName(field);
        analysisRequest.setFieldValue(keyWord);
        analysisRequest.setShowMatch(true);
        analysisRequest.setQuery(queryWord);
        FieldAnalysisResponse process = analysisRequest.process(solrClient, collection);
        return process;
    }

    public void remove(String collection, String id) {
        try {
            solrClient.deleteById(collection, id);
            solrClient.commit(collection);
        } catch (Exception e) {
            throw new BizException(SearchException.SEARCH_DELETE_ERROR.getCode(), SearchException.SEARCH_DELETE_ERROR.getMsg());
        }
    }
}


