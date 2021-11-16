package com.chen.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "book_ext")
public class BookExt {
    @TableId(value = "book_id")
    private Integer bookId;
    private String bookSummary;
    private String bookContent;
}
