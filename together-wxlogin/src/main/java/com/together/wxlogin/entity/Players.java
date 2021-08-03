package com.together.wxlogin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *数据库 表players 实体类
 */
@Data
@TableName("players")
public class Players {

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "account_name")
    private String accountName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "signature")
    private String signature;


}
