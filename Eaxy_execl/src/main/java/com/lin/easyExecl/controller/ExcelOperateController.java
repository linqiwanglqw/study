package com.lin.easyExecl.controller;

import com.lin.easyExecl.execlRead.ExeclReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/excel")
public class ExcelOperateController {

    @Autowired
    ExeclReadService execlReadService;

    @GetMapping("/select")
    public int excelInput(){
        execlReadService.simpleRead();
        return 0;
    }

}
