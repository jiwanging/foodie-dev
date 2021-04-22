package com.felix.controller;

import com.felix.service.CategoryService;
import com.imooc.mapper.CategoryMapperCustom;
import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVo;
import com.imooc.pojo.vo.ItemVo;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("商品分类相关api")
@RestController
public class CategoryController {

    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @ApiOperation("获取所有一级分类")
    @GetMapping("/index/cats")
    public IMOOCJSONResult getRootCategory(){
        List<Category> list = categoryService.queryAllRootLevelCat();
        return IMOOCJSONResult.ok(list);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @ApiOperation("获取指定一级分类下的子分类")
    @GetMapping("/index/subCat/{rootCatId}")
    public IMOOCJSONResult getSubListByRootId(@PathVariable Integer rootCatId){
        if(rootCatId == null)
            return IMOOCJSONResult.errorMsg("父分类不允许为空");

        List<CategoryVo> list = null;
        try{
            list = categoryService.querySubLevelList(rootCatId);
            if(list == null)
                return IMOOCJSONResult.errorMsg("查询为空");
        }catch (Exception e){
            logger.error("查询:"+rootCatId+"子分类信息出错："+ e.toString());
        }
        return IMOOCJSONResult.ok(list);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @ApiOperation("获取最新的6子分类")
    @GetMapping("/index/sixNewItems/{rootCatId}")
    public IMOOCJSONResult getNewSixItemByRootCatId(@PathVariable Integer rootCatId){
        if(rootCatId == null)
            return IMOOCJSONResult.errorMsg("父分类不允许为空");
        List<ItemVo> resultData = null;
        try{
            resultData = categoryService.getNewSixItem(rootCatId);
            if(resultData == null)
                return IMOOCJSONResult.errorMsg("查询为空");
        }catch (Exception e){
            logger.error("查询:"+rootCatId+"子分类信息出错："+ e.toString());
        }
        return IMOOCJSONResult.ok(resultData);
    }


}
