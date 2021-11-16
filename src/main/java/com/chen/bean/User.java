package com.chen.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;
    private String name;
    private String sex;
    private Integer age;
    private byte[] face;
    private Double salary;
    private Date borthday;

}
