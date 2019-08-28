package com.hecm.mystudent.util;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnitTestBase {
    private ClassPathXmlApplicationContext context;

    private String springXmlPath;

    public UnitTestBase(){}
    public UnitTestBase(String springXmlPath){
        this.springXmlPath=springXmlPath;
    }
    @Before
    public void  before(){
        if (springXmlPath == null){
            springXmlPath="classpath*:spring-*.xml";
        }
        try {
            context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
            context.start();
        }catch (BeansException e){
            e.printStackTrace();
        }

    }

    @After
    public void after(){
    context.destroy();
    }


    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId){
        return (T)context.getBean(beanId);

    }

   /* protected <T extends Object> T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }
*/

}
