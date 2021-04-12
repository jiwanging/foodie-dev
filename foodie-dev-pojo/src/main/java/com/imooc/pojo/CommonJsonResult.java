package com.imooc.pojo;

public class CommonJsonResult {

    //状态
    private Integer status;

    //响应描述信息
    private String msg;

    //响应数据信息
    private Object data;

    public CommonJsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static CommonJsonResult build(Integer status, String msg, Object data) {
        return new CommonJsonResult(status, msg, data);
    }
}
