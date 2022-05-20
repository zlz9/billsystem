package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * userId
     */
    private Long id;

    /**
     * 
     */
    private String nickName;

    /**
     * 
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}