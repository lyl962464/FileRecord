package com.controller;

import com.model.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/getUser")
public class UserController {

    @RequestMapping("/user")
    public User getUser(){
        User user = new User();
        user.setName("test");
        return user;
    }
}
