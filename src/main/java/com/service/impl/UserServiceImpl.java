package com.service.impl;

import ch.qos.logback.core.util.StringCollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pojo.User;
import com.service.UserService;
import com.mapper.UserMapper;
import com.utils.JWTUtils;
import com.utils.Result;
import com.vo.params.LoginParams;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration;
import org.springframework.stereotype.Service;

import java.time.format.ResolverStyle;
import java.util.Map;

/**
* @author 23340
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-05-18 10:42:54
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
@Autowired
UserMapper userMapper;
    @Override
    public Result login(LoginParams loginParams) {
        /**
         * 1.检查参数是否合法
         * 2.根据用户名和密码去user表查询是否存在
         * 3.如果不存在，登录失败，
         * 4，如果存在，生成token返回前端
         */
        String nickName = loginParams.getNickName();
        String password = loginParams.getPassword();
        if (StringUtils.isBlank(nickName)||StringUtils.isBlank(password)) {
            return Result.fail(500,"参数不合法");
        }
        /**
         *查询用户
         */
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getNickName,nickName);
        lambdaQueryWrapper.eq(User::getPassword,password);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        /**
         * 如果用户不存在，返回错误
         */
        if (user == null) {
            return Result.fail(400,"用户不存在");
        }
        /**
         * 获取 用户id，生成token返回前端
         */
        return Result.success(user);
//        String token = JWTUtils.createToken(user.getId());
//
//        return Result.success(token);
    }

    @Override
    public Result findUserByToken(String token) {
        /**
         * token合法性校验
         * 如果失败，返回错误
         * 如果成功，返回结果
         */
        if (StringUtils.isBlank(token)) {
            return Result.fail(303,"token不合法");
        }
        Map<String, Object> checkToken = JWTUtils.checkToken(token);
        if (checkToken == null) {
            return null;
        }
        return Result.success(token);
    }
}




