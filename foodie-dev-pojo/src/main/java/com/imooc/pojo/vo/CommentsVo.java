package com.imooc.pojo.vo;

public class CommentsVo {

    private Integer totalCounts;//评论总数
    private Integer goodCounts;//好评总数
    private Integer normalCounts;//中评总数
    private Integer badCounts;//差评总数


    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Integer getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(Integer goodCounts) {
        this.goodCounts = goodCounts;
    }

    public Integer getNormalCounts() {
        return normalCounts;
    }

    public void setNormalCounts(Integer normalCounts) {
        this.normalCounts = normalCounts;
    }

    public Integer getBadCounts() {
        return badCounts;
    }

    public void setBadCounts(Integer badCounts) {
        this.badCounts = badCounts;
    }

    @Override
    public String toString() {
        return "CommentsVo{" +
                "totalCounts=" + totalCounts +
                ", goodCounts=" + goodCounts +
                ", normalCounts=" + normalCounts +
                ", badCounts=" + badCounts +
                '}';
    }
}
