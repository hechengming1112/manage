package com.hecm.mystudent.interfase.three;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MoocBeanName implements BeanNameAware, ApplicationContextAware {
    private String beanName;
    @Override
    public void setBeanName(String s) {
    this.beanName=s;
        System.out.println("MoocBeanName:"+s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext:"+applicationContext.getBean(this.beanName).hashCode());
    }
}
