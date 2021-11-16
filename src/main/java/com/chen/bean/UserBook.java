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
@TableName(value = "User_book")
public class UserBook {
    @TableId(value = "user_id")
    private Integer userId;
    @TableId(value = "book_id")
    private Integer bookId;
    private Date cjsj;

}
