package com.lin;

import com.lin.service.MonitorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyThreadApplicationTests {

    @Autowired
    private MonitorService monitorService;

    @Test
    void contextLoads() {
        monitorService.monitor();
    }

}
