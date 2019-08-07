package com.study.cn.springbootall.thread;

/**
 * @author huwei
 * @date 2019/8/7 11:10
 * <p> description:</>
 */
public class MyThread extends Thread{

    private static volatile boolean flag = true;

    /**
     * 如果变量没有被内存可见。。线程只能看到自己的变量flag==true，回一直while true
     * 因为每个线程都是从主内存中copy一份变量回显到自己的内存中进行操作，并且不能看到其他线程操作的变量。
     * 需要看到的话，则需要使用volatile关键词
     */
    //private static boolean flag = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (flag) {

        }
        System.out.println("线程停止了");
    }

    public static void main(String[] args) throws InterruptedException {
        //主线程
        System.out.println(Thread.currentThread().getName());
        //新开线程
        new MyThread().start();
        Thread.sleep(3000);
        flag = false;
    }
}
