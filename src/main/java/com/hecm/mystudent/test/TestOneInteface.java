package com.hecm.mystudent.test;

import com.hecm.mystudent.interfase.one.OneInterface;
import com.hecm.mystudent.interfase.two.IntefaseService;
import com.hecm.mystudent.util.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestOneInteface extends UnitTestBase {
    public TestOneInteface(){
        super("classpath*:spring-ioc.xml,classpath*:spring-ingection.xml");
    }

    @Test
    public void TestHello(){
        OneInterface onInterface = super.getBean("onInterface");
        System.out.println(onInterface.hello("我的输入参数"));


    }

    @Test
    public void testSetter(){
        IntefaseService intefaseService=super.getBean("intefaseService");
        intefaseService.save("这是要保存的数据");

    }
    @Test
    public void testCons(){
        IntefaseService intefaseService=super.getBean("intefaseService");
        intefaseService.save("这是要保存的数据");

    }


}
