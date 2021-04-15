package com.felix.controller;

import com.felix.service.CarouselService;
import com.imooc.enums.YesOrNo;
import com.imooc.pojo.Carousel;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("轮播图相关api")
@RestController
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation("获取所有轮播图")
    @GetMapping("/index/carousel")
    public IMOOCJSONResult getAllCarousel(){
        List<Carousel> list =  carouselService.queryAll(YesOrNo.yes.type);
        return IMOOCJSONResult.ok(list);
    }
}
