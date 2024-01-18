package org.example.project.Multithreading;

public class UsingConcurrentGather {
    public static void main(String[] args) {
        /**
         * @使用Concurrent集合
         * BlockingQueue的意思就是说，当一个线程调用这个TaskQueue的getTask()方法时，该方法内部可能会让线程变成等待状态，直到队列条件满足不为空，线程被唤醒后，getTask()方法才会返回。
         * 因为BlockingQueue非常有用，所以我们不必自己编写，可以直接使用Java标准库的java.util.concurrent包提供的线程安全的集合：ArrayBlockingQueue。
         * 除了BlockingQueue外，针对List、Map、Set、Deque等，java.util.concurrent包也提供了对应的并发集合类。我们归纳一下：
         */

        /**
         * @小结
         * 使用java.util.concurrent包提供的线程安全的并发集合可以大大简化多线程编程：
         * 多线程同时读写并发集合是安全的；
         * 尽量使用Java标准库提供的并发集合，避免自己编写同步代码。
         */

    }
}
