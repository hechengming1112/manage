package com.hecm.mystudent.interfase.three;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Lifecycle {//implements  InitializingBean , DisposableBean {

    public void defaultInit(){
        System.out.println("defaultInit");
    }
    public void defaultDestroy(){
        System.out.println("defaultDestroy");
    }
    /*private void start() {
        System.out.println("start.");
    }
    private void stop(){
        System.out.println("stop.");
    }
*/
   /* @Override
    public void destroy() throws Exception {
        System.out.println("destroy");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }*/
}
