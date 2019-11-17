package com.huang.ai.bing.threads;

import java.util.concurrent.*;

/**
 *
 *
 *
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
                );
        try{
            for (int i = 0; i < 20; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 正在办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    public static void init() {
        //一个池5个线程
        //执行长期的任务，性能好很多
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一个任务一个任务执行的场景
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //适合：执行很多短周期异步的小程序或者负载较轻的服务器
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try{
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 正在办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
