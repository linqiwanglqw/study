package com.lin.easyExecl.execlVO;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class execlData implements Serializable {
    @ExcelProperty("名称标题")
    private String name;
    @ExcelProperty("年龄标题")
    private Integer age;

//    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    @ExcelProperty("生日标题")
    private Date birthday;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String sex;
}
