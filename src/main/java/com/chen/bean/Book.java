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
@TableName(value = "book")
public class Book {
    @TableId(value = "book_id",type = IdType.AUTO)
    private Integer bookId;
    private String bookName;
    private Float price;
    private String content;
}
