package org.example.project.Multithreading;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        /**
         * @中断线程
         * 需要在其他线程中对目标线程调用interrupt()方法
         */
        Thread t = new MyThread2();
        t.start();
        Thread.sleep(1000); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("main end");

        /**
         * 另一个常用的中断线程的方法是设置标志位。我们通常会用一个running标志位来标识线程是否应该继续运行，在外部线程中，通过把HelloThread.running置为false，就可以让线程结束：
         * 例如：
         *  public volatile boolean running = true;
         */

        /**
         * @volatile
            每次访问变量时，总是获取主内存的最新值；
            每次修改变量后，立刻回写到主内存。
         */

    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        int n = 0;
        while (!interrupted()){
            n++;
            System.out.println(n+"hello");
        }
//        interrupt();
    }
}
