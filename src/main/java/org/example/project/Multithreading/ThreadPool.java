package org.example.project.Multithreading;

public class ThreadPool {
    public static void main(String[] args) {
        /**
         * @线程池
         *
         * 复用一组线程：
         * 把很多小任务让一组线程来执行，而不是一个任务对应一个新线程。这种能接收大量小任务并进行分发处理的就是线程池。
         *
         * 简单地说，线程池内部维护了若干个线程，没有任务的时候，这些线程都处于等待状态。如果有新任务，
         * 就分配一个空闲线程执行。如果所有线程都处于忙碌状态，新任务要么放入队列等待，要么增加一个新线程进行处理。
         *
         * 因为ExecutorService只是接口，Java标准库提供的几个常用实现类有：
            FixedThreadPool：线程数固定的线程池；
            CachedThreadPool：线程数根据任务动态调整的线程池；
            SingleThreadExecutor：仅单线程执行的线程池。
         *
         *
         * 线程池在程序结束的时候要关闭。使用shutdown()方法关闭线程池的时候，它会等待正在执行的任务先完成，然后再关闭。
         * shutdownNow()会立刻停止正在执行的任务，awaitTermination()则会等待指定的时间让线程池关闭。
         */

        // Java标准库提供了ExecutorService接口表示线程池，它的典型用法如下：（Executor:执行者）
        /*
        // 创建固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // 提交任务
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);
        */


        /**
         * @ScheduledThreadPool
         * 还有一种任务，需要定期反复执行，例如，每秒刷新证券价格。这种任务本身固定，需要反复执行的，可以使用ScheduledThreadPool。放入ScheduledThreadPool的任务可以定期反复执行。
         */

        /**
         * @小结
        JDK提供了ExecutorService实现了线程池功能：

        线程池内部维护一组线程，可以高效执行大量小任务；

        Executors提供了静态方法创建不同类型的ExecutorService；

        必须调用shutdown()关闭ExecutorService；

        ScheduledThreadPool可以定期调度多个任务。


         */


    }
}
