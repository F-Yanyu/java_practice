package org.example.project.Multithreading;

import java.time.LocalDateTime;

public class DaemonThreads {
    public static void main(String[] args) {
        /**
         * @守护线程
         * 守护线程是指为其他线程服务的线程。在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
         *
         * 因此，JVM退出时，不必关心守护线程是否已结束。
         *
         * 如何创建守护线程呢？方法和普通线程一样，只是在调用start()方法前，调用setDaemon(true)把该线程标记为守护线程：
         */
        Thread t = new TimerThread();
        t.setDaemon(true);
        t.start();
        System.out.println("打印");
    }
}


class TimerThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println(LocalDateTime.now());
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}