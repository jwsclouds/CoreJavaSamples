package com.jwsclouds.samples.java8;

class RunnableLambdaExample {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable without lambda "+ Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        new Thread(()->{
            System.out.println("Runnable with lambda "+Thread.currentThread().getName());
        }).start();
        System.out.println("Main Thread "+ Thread.currentThread().getName());

    }
}