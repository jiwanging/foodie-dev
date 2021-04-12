package com.imooc.enums;

public enum Sex {


    man(1,"男"),
    woman(2,"女"),
    secret(3,"保密");

    public Integer type;

    public String value;

    Sex(Integer type , String value){

        this.type = type;
        this.value = value;
    }
}
