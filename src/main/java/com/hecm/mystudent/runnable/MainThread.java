package com.hecm.mystudent.runnable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
    public static void main(String[] args) {
       /* LiftOff liftOff = new LiftOff();
        liftOff.run();*/
       /* Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("waiting for LiftOff");*/
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i=0;i<5;i++){
            e.execute(new LiftOff());
            //new Thread(new LiftOff()).start();

    }
        e.shutdown();

    }
}
