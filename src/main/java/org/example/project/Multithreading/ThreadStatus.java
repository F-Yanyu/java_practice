package org.example.project.Multithreading;

public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        /**
         * @线程的状态
            New：新创建的线程，尚未执行；

            Runnable：运行中的线程，正在执行run()方法的Java代码；
            Blocked：运行中的线程，因为某些操作被阻塞而挂起；
            Waiting：运行中的线程，因为某些操作在等待中；
            Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；

            Terminated：线程已终止，因为run()方法执行完毕。
         *
         * 线程终止的原因有：
            线程正常终止：run()方法执行到return语句返回；
            线程意外终止：run()方法因为未捕获的异常导致线程终止；
            对某个线程的Thread实例调用stop()方法强制终止（强烈不推荐使用）。
         */


        // 一个线程还可以等待另一个线程直到其运行结束。
        Thread t = new Thread(()->{
            System.out.println("线程run()");
        });
        System.out.println("start");
        t.start();
        t.join(); // 等到线程t执行完后才继续往下执行自身线程，join(long)的重载方法也可以指定一个等待时间，超过等待时间后就不再继续等待。
        System.out.println("end");
    }
}
