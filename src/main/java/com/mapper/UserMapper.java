package com.mapper;

import com.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 23340
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-05-18 10:42:54
* @Entity com.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




