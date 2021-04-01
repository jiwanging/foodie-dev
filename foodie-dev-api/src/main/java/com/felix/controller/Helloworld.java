package com.felix.controller;

import com.felix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/helloworld")
    public String helloworld(){

        return "hello world" + userService.getUserInfoById(1);
    }
}
