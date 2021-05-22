package com.felix.controller;

import cn.hutool.core.util.StrUtil;
import com.imooc.pojo.bo.ShopcartItemBo;
import com.imooc.pojo.vo.PagedGridResult;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api("购物车相关api")
@RestController()
@RequestMapping("shopcart")
public class ShopCartController {
    private Logger logger = LoggerFactory.getLogger(ShopCartController.class);

    @ApiOperation(value = "添加购物车信息至服务器", notes = "添加购物车信息至服务器", httpMethod = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult addShopcart(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "ShopcartItemBo", value = "购物车对象", required = true)
            @RequestBody ShopcartItemBo shopcartItemBo,
            HttpServletRequest request,
            HttpServletResponse response){

        //参数校验
        if(StrUtil.hasEmpty(userId)){
            return IMOOCJSONResult.errorMsg("用户信息不能为空");
        }
        if(shopcartItemBo == null){
            return IMOOCJSONResult.errorMsg("购物车信息为空");
        }
        logger.info(shopcartItemBo.toString());

        // TODO 前端用户在登录的情况下，添加商品到购物车，会同时在后端同步购物车到redis缓存
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "删除购物车数据", notes = "删除购物车数据", httpMethod = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult delShopcart(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "specId", value = "规格id", required = true)
            @RequestBody String specId,
            HttpServletRequest request,
            HttpServletResponse response){

        //参数校验
        if(StrUtil.hasEmpty(userId)){
            return IMOOCJSONResult.errorMsg("用户信息不能为空");
        }
        if(StrUtil.hasEmpty(specId)){
            return IMOOCJSONResult.errorMsg("规格信息不能为空");
        }

        // TODO 用户在页面删除购物车中的商品数据，如果此时用户已经登录，则需要同步删除后端购物车中的商品
        return IMOOCJSONResult.ok();
    }
}
