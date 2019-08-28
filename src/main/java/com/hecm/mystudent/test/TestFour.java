package com.hecm.mystudent.test;

import com.hecm.mystudent.interfase.four.AspectBiz;
import com.hecm.mystudent.util.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestFour extends UnitTestBase {
    public TestFour (){
        super("classpath*:spring-aop-schema-advice.xml");
    }

    @Test
    public void testBiz(){
        AspectBiz aspectBiz= super.getBean("aspectBiz");
        aspectBiz.bzi();
    }
}
