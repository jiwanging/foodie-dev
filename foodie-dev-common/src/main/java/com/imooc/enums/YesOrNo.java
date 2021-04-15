package com.imooc.enums;

public enum YesOrNo {

    yes(1,"显示"),
    no(2,"不显示");

    public Integer type;
    public String desc;

    YesOrNo(Integer type, String desc){
        this.type = type;
        this.desc = desc;
    }

}
