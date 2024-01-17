package org.example.project.Multithreading;

public class ThreadSynchronization {
    public static void main(String[] args) throws InterruptedException {
        /**
         * @线程同步
         *
         * 当多个线程同时运行时，线程的调度由操作系统决定，程序本身无法决定。因此，任何一个线程都有可能在任何指令处被操作系统暂停，然后在某个时间段后继续执行。
         * 这个时候，有个单线程模型下不存在的问题就来了：如果多个线程同时读写共享变量，会出现数据不一致的问题。
         */
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count); // 结果都不是预期的0，而且结果都不一样。
        /*
         * 这是因为对变量进行读取和写入时，结果要正确，必须保证是原子操作。原子操作是指不能被中断的一个或一系列操作。
         *
         * 对共享变量进行读写时，必须保证一组指令以原子方式执行：即某一个线程执行时，其他线程必须等待：
         *
         * 通过加锁和解锁的操作，就能保证3条指令总是在一个线程执行期间，不会有其他线程会进入此指令区间。即使在执行期线程被操作系统中断执行，
         * 其他线程也会因为无法获得锁导致无法进入此指令区间。只有执行线程将锁释放后，其他线程才有机会获得锁并执行。这种加锁和解锁之间的代码块我们称之为临界区（Critical Section），
         * 任何时候临界区最多只有一个线程能执行。
         */

        // 可见，保证一段代码的原子性就是通过加锁和解锁实现的。Java程序使用synchronized关键字对一个对象进行加锁：

        /*
         重新修改以下代码进行加锁
                锁：
                    public static final Object lock = new Object();
                线程中使用：
                    synchronized (Counter.lock){
                        Counter.count += 1;
                    }

                它表示用Counter.lock实例作为锁，两个线程在执行各自的synchronized(Counter.lock) { ... }代码块时，
                必须先获得锁，才能进入代码块进行。执行结束后，在synchronized语句块结束会自动释放锁。这样一来，对Counter.count变量进行读写就不可能同时进行。
                上述代码无论运行多少次，最终结果都是0。
         */


        /**
         * @小结
         * 多线程同时读写共享变量时，可能会造成逻辑错误，因此需要通过synchronized同步；
         * 同步的本质就是给指定对象加锁，加锁后才能继续执行后续代码；
         * 注意加锁对象必须是同一个实例；
         * 对JVM定义的单个原子操作不需要同步。
         */


    }
}

class Counter{
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            synchronized (Counter.lock){
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            synchronized(Counter.lock){
                Counter.count -= 1;
            }
        }
    }
}