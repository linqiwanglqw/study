package com.lin.easyExecl.execlRead;


import com.alibaba.excel.EasyExcel;
import com.lin.easyExecl.execlVO.execlData;
import com.lin.easyExecl.mapper.ExeclMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExeclReadService {

    @Autowired
    ExeclMapper execlMapper;

    String PATH="D:\\Desktop\\";

    public void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = PATH + "text.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取100条数据 然后返回过来 直接调用使用数据就行
        //DemoDataListener是自定义的
        EasyExcel.read(fileName, execlData.class, new DemoDataListener(execlMapper)).sheet().doRead();
    }
}
