package com.service;

import com.pojo.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.utils.Result;
import com.vo.params.PageParams;
import com.vo.params.RecordParams;

/**
* @author 23340
* @description 针对表【record】的数据库操作Service
* @createDate 2022-05-18 10:42:54
*/
public interface RecordService extends IService<Record> {

    Result RecordMoney(PageParams pageParams);

    Result delRecordById(Integer id);

    Result publishRecord(RecordParams recordParams);
}
