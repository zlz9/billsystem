package com.controller;

import com.service.UserService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UsersController {
   @Autowired
    private UserService userService;
   @GetMapping("users")
   public Result currentUser(@RequestHeader("Authorization") String token){
     return userService.findUserByToken(token);
   }
}
