package com.felix.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.felix.service.UserService;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBo;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api("用户操作相关api")
@RestController
@RequestMapping("/passport")
public class UsersController {

    @Autowired
    private UserService userService;

    @ApiOperation("判断当前用户是否存在api")
    @GetMapping("/usernameIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String username){

        //1.判断用户名不能为空
        if(StrUtil.hasEmpty(username)){
            return IMOOCJSONResult.errorMsg("用户名不能为空");
        }

        //2.进行查询
        boolean isExit = userService.queryNameIsExit(username);
        if(isExit)
            return IMOOCJSONResult.ok("用户名已存在");;//查询成功

        return IMOOCJSONResult.errorMsg("用户名不存在");
    }


    @ApiOperation("用户注册创建新用户api")
    @Transactional(propagation = Propagation.REQUIRED)
    @PostMapping("/regist")
    public IMOOCJSONResult registerUser(@RequestBody UserBo userBo){
        if(userBo == null){
            return new IMOOCJSONResult(500,"注册信息不能为空",null);
        }

        //进行注册
        Users user = userService.createUser(userBo);

        //对注册结果进行判断
        if(user == null){
            return new IMOOCJSONResult(500,"注册失败 请检查错误信息",null);
        }
        return new IMOOCJSONResult(200,"注册成功",user);
    }


    @ApiOperation(value = "用户登录api")
    @Transactional(propagation = Propagation.REQUIRED)
    @PostMapping("/login")
    public IMOOCJSONResult Login(@RequestBody UserBo userBo,
                                 HttpServletRequest request, HttpServletResponse response){

        return userService.login(userBo, request, response);
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED)
    @PostMapping("/logout")
    public IMOOCJSONResult Logout(@RequestBody UserBo userBo,
                                 HttpServletRequest request, HttpServletResponse response){

        CookieUtils.deleteCookie(request, response, "user");

        return IMOOCJSONResult.ok();
    }


}
