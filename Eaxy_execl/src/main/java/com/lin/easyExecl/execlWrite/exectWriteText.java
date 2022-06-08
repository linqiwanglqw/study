package com.lin.easyExecl.execlWrite;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.lin.easyExecl.execlVO.execlData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.List;

@Slf4j
public class exectWriteText {

    String PATH="D:\\Desktop\\";

    //写入数据
    private List<execlData> data() {
        List<execlData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            execlData data = new execlData();
            data.setName("名字" + i);
            data.setAge(22);
            data.setBirthday(new Date());
            list.add(data);
        }
        return list;
    }

    @Test
    public void simpleWrite() {
        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = PATH+"text.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, execlData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });
    }



}
