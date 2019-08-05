package com.study.cn.springbootall.lock;

/**
 * @author huwei
 * @date 2019/8/2 14:26
 * <p> description:class类锁</>
 */
public class SynchronizedClasses implements Runnable {

    static SynchronizedClasses instasnce1 = new SynchronizedClasses();
    static SynchronizedClasses instasnce2 = new SynchronizedClasses();

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void method() throws InterruptedException {
        //这里的括号内用this指的是不同的对象，会同步进行。用当前类的class对象，则会锁住class对象
        synchronized (SynchronizedClasses.class) {
            System.out.println("我是类锁的第二钟形式，我叫"+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("我是类锁的第二钟形式，我叫"+Thread.currentThread().getName()+"，线程结束");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instasnce1);
        Thread t2 = new Thread(instasnce2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished....");
    }
}
