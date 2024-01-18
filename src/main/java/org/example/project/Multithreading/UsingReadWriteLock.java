package org.example.project.Multithreading;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UsingReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        /**
         * @使用ReadWriteLock
         * 我们实现：允许多个线程同时读，但只要有一个线程在写，其他线程就必须等待：
         * 使用ReadWriteLock可以解决这个问题，它保证：
        只允许一个线程写入（其他线程既不能写入也不能读取）；
        没有写入时，多个线程允许同时读（提高性能）。
         */

        // 用ReadWriteLock实现这个功能十分容易。我们需要创建一个ReadWriteLock实例，然后分别获取读锁和写锁：



        /**
         * @小结 使用ReadWriteLock可以提高读取效率：
        ReadWriteLock只允许一个线程写入；
        ReadWriteLock允许多个线程在没有写入时同时读取；
        ReadWriteLock适合读多写少的场景。
         */

    }
}

class CounterOfUsingReadWriteLock {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wLock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wLock.lock();// 加写锁
        try {
            counts[index] += 1;
        } finally {
            wLock.unlock();// 释放写锁
        }
    }

    public int[] get() {
        rlock.lock();// 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock();// 释放读锁
        }
    }
}
