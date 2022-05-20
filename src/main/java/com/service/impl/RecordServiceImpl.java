package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.CategoryMapper;
import com.pojo.Category;
import com.pojo.Record;
import com.service.RecordService;
import com.mapper.RecordMapper;
import com.utils.Result;
import com.vo.params.PageParams;
import com.vo.params.RecordParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
* @author 23340
* @description 针对表【record】的数据库操作Service实现
* @createDate 2022-05-18 10:42:54
*/
    @Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record>
    implements RecordService{
    @Autowired
RecordMapper recordMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Result RecordMoney(PageParams pageParams) {
        /**
         * 根据分类id查找分类
         */
        Page<Record> page = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        LambdaQueryWrapper<Record> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Record::getDataTime);
        IPage<Record> recordIPage = recordMapper.selectPage(page,queryWrapper);
        List<Record> records = recordIPage.getRecords();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",records);
        map.put("total",page.getTotal());
        return Result.success(map);
    }

    @Override
    public Result delRecordById(Integer id) {
        int deleteById = recordMapper.deleteById(id);
        if (id == null) {
            return Result.fail(405,"删除文章出现错误");
        }
        return Result.success(deleteById);
    }

    @Override
    public Result publishRecord(RecordParams recordParams) {
        /**
         * 1.整理参数
         * 2.发请求
         */
        Record record = new Record();
        record.setMoney(recordParams.getMoney());
        record.setComment(recordParams.getComment());
        record.setDataTime(recordParams.getDataTime());
        int insertRecord = recordMapper.insert(record);
        return Result.success(insertRecord);
    }
}




