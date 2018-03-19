package com.hwua.auction.util;

import java.util.List;

/**
 * @name 分页类
 *
 */
public class Page<T> {

    private int currentPage=1;//当前页码
    private int maxPage;//最大页码数
    private int limit = 2;//默认每一页显示多少条
    private int total;//表中记录的总数
    private String sort;//用于表示排序方式
    private List<Integer> pageNum;//存放翻的数字
    private List<T> resultlist;//存放实体类对象
    private int s;
    public Page() {
    }

    /**
     * @param currentPage 当前页
     * @param maxPage 最大页
     * @param pageNum 页码数组
     * @param resultlist 数据集
     */
    public Page(int currentPage, int maxPage, int total, List<Integer> pageNum, List<T> resultlist) {
        this.currentPage = currentPage;
        this.maxPage = maxPage;
        this.total = total;
        this.pageNum = pageNum;
        this.resultlist = resultlist;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getResultlist() {
        return resultlist;
    }

    public void setResultlist(List<T> resultlist) {
        this.resultlist = resultlist;
    }

    public void setPageNum(List<Integer> pageNum) {
        this.pageNum = pageNum;
    }

    public List<Integer> getPageNum() {
        return pageNum;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @return the sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * @return the s
     */
    public int getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(int s) {
        this.s = s;
    }

}