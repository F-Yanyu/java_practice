package org.example.project.Multithreading;

public class MethodSynchronization {
    public static void main(String[] args) throws InterruptedException {
        /**
         * @同步方法
         *
         */

        /**
         * @小结
         * 用synchronized修饰方法可以把整个方法变为同步代码块，synchronized方法加锁对象是this；
         * 通过合理的设计和数据封装可以让一个类变为“线程安全”；
         * 一个类没有特殊说明，默认不是thread-safe；
         * 多线程能否安全访问某个非线程安全的实例，需要具体问题具体分析。
         */
    }
}


/*
    这样一来，线程调用add()、dec()方法时，它不必关心同步逻辑，因为synchronized代码块在add()、dec()方法内部。
    并且，我们注意到，synchronized锁住的对象是this，即当前实例，这又使得创建多个Counter实例的时候，它们之间互不影响，可以并发执行：
 */
class CounterOfMethodSynchronization{
    private int count = 0;

    /*
    当我们锁住的是this实例时，实际上可以用synchronized修饰这个方法。下面两种写法是等价的：
     */
    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }
    // public synchronized void add(int n){ // 锁住this
    //    count += n;
    // } // 解锁
    // 因此，用synchronized修饰的方法就是同步方法，它表示整个方法都必须用this实例加锁。

    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }

    public int get() {
        return count;
    }
}

