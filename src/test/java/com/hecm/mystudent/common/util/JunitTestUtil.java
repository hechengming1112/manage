package com.hecm.mystudent.common.util;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class JunitTestUtil {
    private static final Logger LOGGER=LoggerFactory.getLogger(JunitTestUtil.class);
    @Before
    public void before(){
        LOGGER.info("开始测试.......");
    }
    @After
    public void after(){
        LOGGER.info("测试结束......");
    }

}
