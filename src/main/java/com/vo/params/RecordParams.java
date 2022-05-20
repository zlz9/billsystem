package com.vo.params;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.pojo.Category;
import lombok.Data;

import java.util.List;
@Data
public class RecordParams {
   @TableId(type = IdType.AUTO)
   private Long id;
   private Long money;
   private List<Category> categories;
   private String dataTime;
   private String comment;
   private Long uId;
}
