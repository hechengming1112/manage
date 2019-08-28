package com.hecm.mystudent.test;

import com.hecm.mystudent.interfase.four.AspectBiz;
import com.hecm.mystudent.interfase.three.AutoWiringService;
import com.hecm.mystudent.interfase.three.BeanScope;
import com.hecm.mystudent.interfase.three.MoocResource;
import com.hecm.mystudent.interfase.two.IntefaseService;
import com.hecm.mystudent.util.UnitTestBase;
import org.junit.Test;

import java.io.IOException;

public class TestBeanScope extends UnitTestBase {
    public TestBeanScope(){
        //super("classpath*:spring-scope.xml,classpath*:spring-lifecycle.xml,classpath*:spring-aware.xml,classpath*:spring-autoWiring.xml");
        super("classpath*:spring-resource.xml");
    }
    @Test
    public void testBeanScope(){
        BeanScope beanScope =super.getBean("beanScope");
        beanScope.say();

        BeanScope beanScope1 =super.getBean("beanScope");
        beanScope1.say();

    }

    @Test
    public void testBeanScope2(){
        BeanScope beanScope =super.getBean("beanScope");
        beanScope.say();

        BeanScope beanScope1 =super.getBean("beanScope");
        beanScope1.say();

    }
    @Test
    public void testLifecycle(){
        super.getBean("lifecycle");
    }

    @Test
    public void testAware(){
        System.out.println("application:"+super.getBean("moocBeanName").hashCode());
    }
    @Test
    public void testAutoWiring(){
        AutoWiringService autoWiringService= super.getBean("autoWiringService");
        autoWiringService.say("这是我的数据");
    }

    @Test
    public void testMoocResource(){
        MoocResource moocResource = super.getBean("moocResource");
        try {
            moocResource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
