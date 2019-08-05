package com.study.cn.springbootall.lock;

/**
 * @author huwei
 * @date 2019/8/1 18:27
 * <p> description:synchronized 锁</>
 */
public class SynchronizedDemo implements Runnable {

    /**
     * 对象锁：
     *  代码块形式：手动指定锁对象
     *  方法锁形式：synchronized修饰的方法(方法修饰的synchronized指的就是this)。锁对象默认为this
     *
     *  类锁：
     *      形式一：synchronized修饰static方法
     *      形式二：synchronized（。class）代码块上
     */

    static SynchronizedDemo instance = new SynchronizedDemo();
    static int i = 0 ;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        //这里的join是指当前线程必须完成后才可以进行下面的代码。
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        //这里不加载 多个线程访问这个方法，变量i的值不能保持一致性
        synchronized (SynchronizedDemo.class){
            for (int j = 0; j < 100000 ; j++) {
                i++;
            }
        }
    }

    /**
     * 面试常用多线程问题
     * 1.两个线程同时访问同一个对象的同步方法     线程会阻塞
     * 2.两个线程同时访问两个对象的同步方法      互不干扰
     * 3.两个线程访问的是synchronized的静态方法  线程会阻塞
     * 4.同时访问同步方法和非同步方法     同时开始i 同时结束
     * 5.访问对象的不同的普通的同步方法   因为synchronized在修饰的时候使用的同一个方法的实例.new Thread(instance)
     *      此刻不同的synchronized修饰的不同的方法，都是使用的this对象，所以会阻塞。。。
     * 6.同时访问静态的synchronized方法和非静态的synchronized方法   类锁的和synchronized锁方法的this是不同的锁。
     * 7.方法抛出异常，是否释放锁。  会释放
     */

    /**
     *
     *如何反编译。。。将java文件编译成class 文件 然后使用javap -verbose 反编译为汇编。。
     * 查询锁机制是存在class文件的对象头里面。。有一个字段叫monitorenter，退出的时候字段为monitorexit
     */

    /**
     *
     * 可重入原理：
     *  加锁计数计算器：
     *      jvm负责跟踪对象加锁的的次数
     *      线程第一次给对象加锁的时候，计数变成1，每当这个相同的线程再次在此对象上获得锁时，计数会递增。
     *      每当任务离开时，计数递减，每当计数为0时，锁完全释放。
     */

    /**
     *  synchronized中可见性：
     *          将主内存中的变量存入本地内存中。。
     */
    /**
     *  synchronized中缺陷：
     *      效率低：
     *          锁的释放情况少；
     *          获取锁的时间不能设置超时；
     *          不能中断锁。
     *      不够灵活：
     *          读写锁的对比。
     */

    /**
     *  synchronized常见面试题：
     *      对象头中的锁对象不能为空；
     *          如何我们使用一个为null的对象作为锁对象，那么这个锁对象就是无效。
     *      作用域不能太大；
     *          效率降低。。只需要需要同步的代码块。
     *      避免死锁；
     *          两个线程相互等待进而进入死循环。。
     *
     *      synchronized和lock如何选择：
     *          可以先使用java。util.current下的包。
     */
}
