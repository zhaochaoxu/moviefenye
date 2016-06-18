package com.chaoxu.util;

import java.util.List;

/**
 * Created by dell on 2016/6/18.
 */
public class Page<T> {
    /**
     * 获取总记录数
     */
    private Integer totalsize;

    /**
     * 获取页面总数
     */
    private Integer totalPage;

    /**
     * 获取页码
     */
    private Integer pageNo;
    /**
     * 获取页面多少条数据
     */
    private Integer pageSize;

    /**
     * 获取当前页面数据
     */

     private List<T> items;

    /**
     * 获取当前页面起始行数
     */
    private Integer start;

    public Page(Integer pageNo,Integer pageSize,Integer totalsize){
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalsize = totalsize;

        //计算页面总数
        totalPage = totalsize/pageSize;
        if(totalPage%pageSize!=0){
            totalPage++;
        }

        if (pageNo > totalPage) {
            this.pageNo = totalPage;
        }

        if(pageNo <= 0){
            this.pageNo = 1;
        }

        start = (this.pageNo - 1)*pageSize;
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getStart() {
        return start;
    }
}
