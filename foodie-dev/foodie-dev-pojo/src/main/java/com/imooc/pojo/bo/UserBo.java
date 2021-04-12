package com.imooc.pojo.bo;

import io.swagger.annotations.ApiModelProperty;

public class UserBo {

    @ApiModelProperty(value = "用户名" , name = "username")
    private String username;

    @ApiModelProperty(value = "用户密码" , name = "password")
    private String password;

    @ApiModelProperty(value = "确认密码" , name = "comfirmPassword")
    private String confirmPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
