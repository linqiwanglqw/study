package com.lin.easyExecl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.easyExecl.mapper")
public class EaxyExeclApplication {

    public static void main(String[] args) {
        SpringApplication.run(EaxyExeclApplication.class, args);
    }
}
