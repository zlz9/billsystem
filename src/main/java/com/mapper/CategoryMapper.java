package com.mapper;

import com.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 23340
* @description 针对表【category】的数据库操作Mapper
* @createDate 2022-05-18 10:42:54
* @Entity com.pojo.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




