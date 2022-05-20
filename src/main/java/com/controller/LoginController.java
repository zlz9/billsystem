package com.controller;

import com.service.UserService;
import com.utils.Result;
import com.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("login")
    public Result login(@RequestBody LoginParams loginParams){
        return userService.login(loginParams);
    }
}
