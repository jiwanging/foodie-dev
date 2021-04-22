package com.imooc.enums;

public enum CommentsLevel {

    goodComments(1,"好评"),
    normalComments(2,"中评"),
    badComments(3,"差评");

    public Integer level;
    public String desc;

    CommentsLevel(Integer level, String desc) {
        this.level = level;
        this.desc = desc;
    }
}
