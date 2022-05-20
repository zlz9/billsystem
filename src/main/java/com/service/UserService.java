package com.service;

import com.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.utils.Result;
import com.vo.params.LoginParams;

/**
* @author 23340
* @description 针对表【user】的数据库操作Service
* @createDate 2022-05-18 10:42:54
*/
public interface UserService extends IService<User> {

    Result login(LoginParams loginParams);

    Result findUserByToken(String token);
}
