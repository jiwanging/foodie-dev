package com.felix.controller;

import com.felix.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.beans.Transient;

@ApiIgnore
@RestController
public class Helloworld {

    final static Logger logger = LoggerFactory.getLogger(Helloworld.class);

    @Autowired
    private UserService userService;

    @ApiOperation("helloworld程序 api")
    @Transactional(propagation = Propagation.REQUIRED)
    @GetMapping(value = "/helloworld")
    public String helloworld(){

        logger.error("打印hello world！");
        return "hello world" + userService.getUserInfoById(1);
    }
}
