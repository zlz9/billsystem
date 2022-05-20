package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pojo.Category;
import com.service.CategoryService;
import com.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 23340
* @description 针对表【category】的数据库操作Service实现
* @createDate 2022-05-18 10:42:54
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




