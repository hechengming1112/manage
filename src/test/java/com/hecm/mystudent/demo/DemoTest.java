package com.hecm.mystudent.demo;

import admin.com.student.demo.domain.Demo;
import admin.com.student.demo.service.DemoService;
import com.hecm.mystudent.common.util.JunitTestUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DemoTest extends JunitTestUtil {
    private static final Logger LOGGER= LoggerFactory.getLogger(DemoTest.class);
    @Autowired
    private DemoService demoService;
    @Test
    public void demoTest(){
        List<Demo> demoList = demoService.getDemoList();
        LOGGER.info("信息:"+demoList);

    }
}
