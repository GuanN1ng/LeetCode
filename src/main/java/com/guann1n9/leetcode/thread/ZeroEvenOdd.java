package com.guann1n9.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * 假设有这么一个类：
 * <p>
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 */
public class ZeroEvenOdd {

    private int n;

    //A 利用信号量
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    //B 无锁  volatile 关键字

    private volatile int state = 0;


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            /**
             * blocking until one is available, or the thread is {@linkplain Thread#interrupt interrupted
             */
            zero.acquire();
            System.out.print(0);
            if ((i & 1) == 0) {
                /**
                 * There is no requirement that a thread that releases a permit must
                 * have acquired that permit by calling {@link #acquire}.
                 */
                odd.release();  //release方法不需要持有信号量，效果+1
            } else {
                even.release();
            }
        }
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            even.acquire();
            System.out.print(i);
            zero.release();
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            odd.acquire();
            System.out.print(i);
            zero.release();
        }
    }


    /**
     * 利用volatile关键字实现
     */


    public void zero2() {

        for (int i = 0; i < n; i++) {

            while (state != 0) {
                /**
                 * A hint to the scheduler that the current thread is willing to yield
                 * its current use of a processor. The scheduler is free to ignore this hint.
                 */
                Thread.yield();
            }
            System.out.println(0);
            if ((i & 1) == 1) {
                state = 2;
            } else {
                state = 1;
            }
        }
    }

    public void odd2() {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            System.out.println(i);
            state = 0;
        }
    }

    public void even2() {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }
            System.out.println(i);
            state = 0;
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(4);
        new Thread(() -> {
                zeroEvenOdd.zero2();

        }).start();
        new Thread(() -> {
                zeroEvenOdd.odd2();

        }).start();
        new Thread(() -> {
                zeroEvenOdd.even2();
        }).start();
    }


}
