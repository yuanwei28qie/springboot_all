package com.study.cn.springbootall.thread;

/**
 * @author huwei
 * @date 2019/8/1 15:20
 * <p> description:创建线程</>
 */
public class CreateThread {
    /**
     * 创建线程的三种方式
     * 方式一：
     *  继承Thread
     * 方式二：
     *  实现runnable
     * 方式三：
     *  实现callable
     */
    // main方法就是一个主线程

    // 获取当前正在运行的线程
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        // 线程名字
        String name = thread.getName();
        // 线程id
        long id = thread.getId();
        // 线程优先级
        int priority = thread.getPriority();
        // 是否存活
        boolean alive = thread.isAlive();
        // 是否守护线程
        boolean daemon = thread.isDaemon();

        // Thread[name=main, id=1 ,priority=5 ,alive=true ,daemon=false]
        System.out.println("Thread[name=" + name + ", id=" + id + " ,priority=" + priority + " ,alive=" + alive + " ,daemon=" + daemon + "]");

    }
}

class ThreadOne extends Thread {
    @Override
    public void run() {
        System.out.println("创建了线程："+this.getName());
    }
}
