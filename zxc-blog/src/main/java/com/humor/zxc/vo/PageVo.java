package com.humor.zxc.vo;

import java.util.ArrayList;
import java.util.List;

public class PageVo<T> {
    private List<T> results;
    private Integer pageCount;

    public PageVo() {
    }

    public PageVo(List<T> results, Integer pageCount) {
        this.results = results;
        this.pageCount = pageCount;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageVo{");
        sb.append("results=").append(results);
        sb.append(", pageCount=").append(pageCount);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 截取分页
     *
     * @param listPage
     * @param pageNum
     * @param <T>
     * @return
     */
    public static <T> List<T> listPage(List<T> listPage, int pageNum, int pageSize) {
        if (pageNum <= 0) {
            pageNum = 1;
        }

        int start =  (pageNum - 1) * pageSize;
        int size = start + pageSize;

        if (start >= listPage.size()) {
            return new ArrayList<T>();
        }

        if (size > listPage.size()) {
            size = listPage.size();
        }

        return listPage.subList(start, size);
    }
}
