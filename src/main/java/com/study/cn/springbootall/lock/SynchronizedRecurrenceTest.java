package com.study.cn.springbootall.lock;

import org.junit.jupiter.api.Test;

/**
 * @author huwei
 * @date 2019/8/2 15:30
 * <p> description:
 * <p>
 * 可重入(递归锁)：
 * 概念：指的是同一个线程在外层的函数获得锁之后，内层函数可以再次获得锁。
 * 好处：避免死锁，提升封装性。
 * 粒度：是在线程的粒度上，而不是调用上。
 *
 * 不可中断性：
 * 概念：如果有人拿到锁，只能等待。
 * /</>
 */
public class SynchronizedRecurrenceTest {


    int a = 0;

    /**
     * 证明synchronized在同一个方法上是可重入的
     */
    @Test
    public void test01() {
        SynchronizedRecurrenceTest instance = new SynchronizedRecurrenceTest();
        instance.method();
    }

    private synchronized void method() {
        System.out.println("this is method...");
        if (a == 0) {
            a++;
            //递归
            method();
        }
    }

    /**
     * synchronized证明在可重入不一定是在同一个方法
     */
    @Test
    public void test02() {
        SynchronizedRecurrenceTest instance = new SynchronizedRecurrenceTest();
        instance.method01();
        instance.method02();
    }

    private synchronized void method01() {
        System.out.println("this is method01...");
    }

    private synchronized void method02() {
        System.out.println("this is method02...");
    }

    /**
     * synchronized证明在可重入不一定是在同一个类上
     */
    @Test
    public void test03() {
        Son son = new Son();
        son.father();
    }

    public synchronized void father() {
        System.out.println("父类中的方法。。。");
    }

    class Son extends SynchronizedRecurrenceTest {
        @Override
        public synchronized void father() {
            System.out.println("子类中的方法。。。");
            super.father();
        }

    }
}
