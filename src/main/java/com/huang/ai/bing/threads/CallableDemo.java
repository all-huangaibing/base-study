package com.huang.ai.bing.threads;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {

        System.out.println(Thread.currentThread().getName()+"coming" );
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask(new MyThread());
         new Thread(futureTask,"AA").start();
         new Thread(futureTask2,"BB").start();

        System.out.println(futureTask.get());
        System.out.println(futureTask.get());
    }
}
