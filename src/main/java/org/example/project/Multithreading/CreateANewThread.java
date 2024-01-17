package org.example.project.Multithreading;

public class CreateANewThread {
    public static void main(String[] args) {
        /**
         * @创建新线程
         */
        // 要创建一个新线程非常容易，我们需要实例化一个Thread实例，然后调用它的start()方法：
        Thread t = new Thread();
        t.start(); // 启动新线程

        // 但是这个线程启动后实际上什么也不做就立刻结束了。我们希望新线程能执行指定的代码，有以下几种方法：
        // 1. 从Thread派生一个自定义类，然后覆写run方法。
        Thread k = new MyThread();
        k.start();
        /*
        执行上述代码，注意到start()方法会在内部自动调用实例的run()方法。
         */

        // 2.创建Thread实例时，传入一个Runnable实例：
        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();
        // 或者用java8引入的lambda语法进一步简写为：
        Thread n = new Thread(()->{
            System.out.println("我是lambda语法的Thread");
        });
        n.start();

        /**
         * @小结
         * Java用Thread对象表示一个线程，通过调用start()启动一个新线程；
         *
         * 一个线程对象只能调用一次start()方法；
         *
         * 线程的执行代码写在run()方法中；
         *
         * 线程调度由操作系统决定，程序本身无法决定调度顺序；
         *
         * Thread.sleep()可以把当前线程暂停一段时间。
         */
    }
}


class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("start new thread!");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("我是MyRunnable");
    }
}