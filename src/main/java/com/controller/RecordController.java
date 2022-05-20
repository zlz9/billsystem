package com.controller;

import com.service.RecordService;
import com.utils.Result;
import com.vo.params.PageParams;
import com.vo.params.RecordParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RecordController {
    @Autowired
    RecordService recordService;
    @GetMapping("record")
    public Result Record(PageParams pageParams){
        return recordService.RecordMoney(pageParams);
    }
    @DeleteMapping("delRecrod")
    public Result delRecordById(Integer id){
        return recordService.delRecordById(id);
    }
    @PostMapping("publishrecord")
    public Result publishRecord(@RequestBody RecordParams recordParams){
        return recordService.publishRecord(recordParams);
    }
}
