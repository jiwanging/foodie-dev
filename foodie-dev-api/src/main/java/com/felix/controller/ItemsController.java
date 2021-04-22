package com.felix.controller;


import cn.hutool.core.util.StrUtil;
import com.felix.service.ItemService;
import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CommentsVo;
import com.imooc.pojo.vo.ItemsInfoVo;
import com.imooc.pojo.vo.PagedGridResult;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemsController {

    private Logger logger = LoggerFactory.getLogger(ItemsController.class);

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "获取商品详情数据",notes = "获取商品详情数据", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult queryItemsInfo(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @PathVariable String itemId){
        if(StrUtil.hasEmpty(itemId)){
            return IMOOCJSONResult.errorMsg("商品id不能为空");
        }

        ItemsInfoVo itemsInfoVo = new ItemsInfoVo();
        try{
            //查询数据
            Items item = itemService.queryItemById(itemId);
            List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
            List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
            ItemsParam itemsParam = itemService.queryItemParam(itemId);

            //封装数据
            itemsInfoVo.setItem(item);
            itemsInfoVo.setItemImgList(itemImgList);
            itemsInfoVo.setItemSpecList(itemsSpecList);
            itemsInfoVo.setItemParams(itemsParam);
        }catch (Exception e){
            logger.error("获取商品详情数据出错");
        }
        logger.info("获取的商品详情数据如下： ====");
        System.out.println(itemsInfoVo.toString());
        return IMOOCJSONResult.ok(itemsInfoVo);
    }

    @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public IMOOCJSONResult commentLevel(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId){
        CommentsVo commentsVo = null;
        try{
            commentsVo = itemService.queryItemComments(itemId);
        }catch (Exception e) {
            logger.error("查询商品评价等级数量出错");
            e.printStackTrace();
        }
        logger.info("查询商品评价等级信息如下：=====");
        System.out.println(commentsVo.toString());
        return IMOOCJSONResult.ok(commentsVo);
    }

    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public IMOOCJSONResult comments(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId,
            @ApiParam(name = "level", value = "评价等级", required = false)
            @RequestParam Integer level,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
            @RequestParam Integer pageSize) {

        //参数校验
        if(StrUtil.hasEmpty(itemId)){
            return IMOOCJSONResult.errorMsg("商品id不能为空");
        }
        if(page == null  || pageSize == null){
            return IMOOCJSONResult.errorMsg("缺少分页信息");
        }
        PagedGridResult result = null;

        try{
            result = itemService.queryPagedComments(itemId,level,page,pageSize);
        }catch (Exception e){
            logger.error("====查询分页评论信息出现错误====");
            e.printStackTrace();
        }
        logger.info("====查询分页评论信息如下====");
        logger.info(result.toString());
        return IMOOCJSONResult.ok(result);
    }
}
