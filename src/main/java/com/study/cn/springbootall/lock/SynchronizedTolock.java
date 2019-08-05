package com.study.cn.springbootall.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huwei
 * @date 2019/8/2 16:10
 * <p> description:  加锁和释放锁的原理：
 *  现象：
 *  获取和释放锁的时机：内置锁
 * </>
 */
public class SynchronizedTolock {

    public static void main(String[] args) {
        SynchronizedTolock synchronizedTolock = new SynchronizedTolock();
        synchronizedTolock.method01();
        synchronizedTolock.method02();
    }

    public synchronized void method01(){
        System.out.println("我是 synchronized形式的锁。。。");
    }

    public void method02(){
        Lock lock = new ReentrantLock();
        System.out.println("我是 lock形式的锁。。。");
        try{
            //开启锁
            lock.lock();
        }finally {
            //释放锁
            lock.unlock();
        }
    }
}
