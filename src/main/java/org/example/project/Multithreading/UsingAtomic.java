package org.example.project.Multithreading;

public class UsingAtomic {
    public static void main(String[] args) {
        /**
         * @使用Atomic
         * Atomic类是通过无锁（lock-free）的方式实现的线程安全（thread-safe）访问。它的主要原理是利用了CAS：Compare and Set。
         *
         * @小结
         * 使用java.util.concurrent.atomic提供的原子操作可以简化多线程编程：
         *
         * 原子操作实现了无锁的线程安全；
         *
         * 适用于计数器，累加器等。
         */
    }
}
