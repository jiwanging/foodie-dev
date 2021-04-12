package com.felix.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;
import com.imooc.utils.IMOOCJSONResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {


    public Object getUserInfoById(int id);

    public boolean queryNameIsExit(String userName);

    public Users createUser(UserBo userBo);

    public IMOOCJSONResult login(UserBo userBo, HttpServletRequest request,HttpServletResponse response);
}
