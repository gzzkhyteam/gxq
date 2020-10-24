package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：搜索内容返回
 * 修改人：gbl
 * 修改时间：2018/4/9
 * 修改内容：新增
 */
@Data
@ApiModel(value = "SearchRes", description = "搜索返回")
public class SearchResDTO {

    @ApiModelProperty(value = "命中总条数")
    private long total;

    @ApiModelProperty(value = "具体数据")
    private List<IndexItemResDTO> datas = new ArrayList<>();

    @ApiModelProperty(value = "当前第几页")
    private int pageNo;

    @ApiModelProperty(value = " 每页数量")
    private int pageSize;

    public static final String INDEX_TITLE = "title";
    public static final String INDEX_CONTENT = "content";

    /***
     * 增加返回项
     * @param item
     * @param highlightMap
     */
    public void addResItem(IndexItemResDTO item, Map<String, List<String>> highlightMap) {


        List<String> tilelLt = highlightMap.get(INDEX_TITLE);
        List<String> contentLt = highlightMap.get(INDEX_CONTENT);
        String title = item.getTitle();
        String content = item.getContent();
        if (tilelLt != null && tilelLt.size() > 0) {
            title = tilelLt.get(0);
        }
        if (contentLt != null && contentLt.size() > 0) {
            content = contentLt.get(0);
        }

        item.setHighlightTitle(title);
        item.setHighlightContent(content);

        datas.add(item);
    }
}
