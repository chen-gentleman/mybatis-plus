package com.chen.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "User_contact")
public class UserContact {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String usage;
    private String number;
}
