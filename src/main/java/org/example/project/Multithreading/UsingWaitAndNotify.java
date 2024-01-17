package org.example.project.Multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UsingWaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        /**
         * @使用wait和notify
         * wait()方法:
         *      wait()方法必须在当前获取的锁对象上调用，
         *
         *      它不是一个普通的Java方法，而是定义在Object类的一个native方法，也就是由JVM的C代码实现的。
         *      其次，必须在synchronized块中才能调用wait()方法，因为wait()方法调用时，会释放线程获得的锁，wait()方法返回后，线程又会重新试图获得锁。
         *
         * notify()方法：（释义：通知）
         *      如何让等待的线程被重新唤醒，然后从wait()方法返回？答案是在相同的锁对象上调用notify()方法。
         *
         * notifyAll()方法：
         *      将唤醒所有当前正在this锁等待的线程，
         */

        // 例子
        var q = new TaskQueue();
        var ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            var t = new Thread() {
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        var add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (var t : ts) {
            t.interrupt();
        }

        /**
         * @小结
         * wait和notify用于多线程协调运行：
                在synchronized内部可以调用wait()使线程进入等待状态；

                必须在已获得的锁对象上调用wait()方法；

                在synchronized内部可以调用notify()或notifyAll()唤醒其他等待线程；

                必须在已获得的锁对象上调用notify()或notifyAll()方法；

                已唤醒的线程还需要重新获得锁后才能继续执行。
         */
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
