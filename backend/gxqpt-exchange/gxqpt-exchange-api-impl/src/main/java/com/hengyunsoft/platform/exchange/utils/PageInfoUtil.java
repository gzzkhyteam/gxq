package com.hengyunsoft.platform.exchange.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * com.hengyunsoft.platform.exchange.utils
 * gxqpt
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：zhaopengfei
 * 修改时间：2018/8/31
 * 修改内容：
 */
public class PageInfoUtil {
    public static PageInfo getPage(int pageNum, int pageSize, int totalRow, List<Object> list){

        int size,startRow,endRow,total,pages,prePage,nextPage
                ,navigatePages,navigatepageNums,navigateFirstPage,navigateLastPage;
        boolean hasNextPage,isLastPage,isFirstPage,hasPreviousPage;
        int dist = totalRow % pageSize;
        if (dist>0){
            pages = totalRow / pageSize+1;
        }else {
            pages = totalRow / pageSize;
        }
        isLastPage = pageNum == pages;
        hasNextPage = pageNum < pages;
        hasPreviousPage =pageNum > 1;
        isFirstPage = pageNum == 1;
        startRow = (pageNum-1)*pageSize+1;
        endRow = pageNum*pageSize;
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setSize(totalRow);
        pageInfo.setStartRow(startRow);
        pageInfo.setEndRow(endRow);
        pageInfo.setTotal(totalRow);
        pageInfo.setPages(pages);
        pageInfo.setList(list);
        pageInfo.setPrePage(pageNum);
        if (pageNum < pages) {
            pageInfo.setNextPage(pageNum + 1);
        }
        pageInfo.setIsFirstPage(isFirstPage);
        pageInfo.setIsLastPage(isLastPage);
        pageInfo.setHasPreviousPage(hasPreviousPage);
        pageInfo.setHasNextPage(hasNextPage);
        pageInfo.setEndRow(totalRow);
        pageInfo.setNavigatePages(pages);
        pageInfo = calcNavigatepageNums(pageInfo);
        return pageInfo;
    }

    private static PageInfo calcNavigatepageNums(PageInfo pageInfo) {
        int[] navigatepageNums;
        int navigateFirstPage;
        int navigateLastPage;
        int i;
        if (pageInfo.getPages() <= pageInfo.getNavigatePages()) {
            navigatepageNums = new int[pageInfo.getPages()];

            for(i = 0; i < pageInfo.getPages(); ++i) {
                navigatepageNums[i] = i + 1;
            }
        } else {
            navigatepageNums = new int[pageInfo.getNavigatePages()];
            i = pageInfo.getPageNum() - pageInfo.getNavigatePages() / 2;
            int endNum = pageInfo.getPageNum() + pageInfo.getNavigatePages() / 2;
            if (i < 1) {
                i = 1;

                for(i = 0; i <pageInfo.getNavigatePages(); ++i) {
                    navigatepageNums[i] = i++;
                }
            } else if (endNum > pageInfo.getPages()) {
                endNum = pageInfo.getPages();

                for(i = pageInfo.getNavigatePages() - 1; i >= 0; --i) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
                for(i = 0; i <pageInfo.getNavigatePages(); ++i) {
                    navigatepageNums[i] = i++;
                }
            }
        }
        pageInfo.setNavigatepageNums(navigatepageNums);

        if (navigatepageNums != null && navigatepageNums.length > 0) {
            navigateFirstPage = navigatepageNums[0];
            navigateLastPage = navigatepageNums[navigatepageNums.length - 1];
            pageInfo.setNavigateFirstPage(navigateFirstPage);
            pageInfo.setNavigateLastPage(navigateLastPage);
        }
        return pageInfo;
    }
}
