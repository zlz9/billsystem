package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName record
 */
@TableName(value ="record")
@Data
public class Record implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 金额
     */
    private Long money;

    /**
     * 分类
     */
    private Long categoryId;

    /**
     * 时间
     */
    private String dataTime;

    /**
     * 评论
     */
    private String comment;

    /**
     * 用户id
     */
    private Long uId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}