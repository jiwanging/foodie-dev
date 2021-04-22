package com.imooc.pojo.vo;

import java.util.List;

public class PagedGridResult {

    private List<ItemsCommentsVo> rows;
    private Integer total;//总页数
    private long records; //总记录数
    private int page;// 当前页数

    public List<ItemsCommentsVo> getRows() {
        return rows;
    }

    public void setRows(List<ItemsCommentsVo> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PagedGridResult{" +
                "rows=" + rows +
                ", total=" + total +
                ", records=" + records +
                ", page=" + page +
                '}';
    }
}
