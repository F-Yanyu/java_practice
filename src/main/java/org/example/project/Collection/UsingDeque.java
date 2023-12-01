package org.example.project.Collection;

public class UsingDeque {
    public static void main(String[] args) {
        /**
         * @使用Deque
         * 允许两头都进，两头都出，这种队列叫双端队列（Double Ended Queue），学名Deque。
         *
         * Java集合提供了接口Deque来实现一个双端队列，它的功能是：
         *  - 既可以添加到队尾，也可以添加到队首；
         *  - 既可以从队首获取，又可以从队尾获取。
         *
         * Deque接口实际上扩展自Queue：
         * 使用Deque，推荐总是明确调用offerLast()/offerFirst()或者pollFirst()/pollLast()方法。
         * Deque是一个接口，它的实现类有ArrayDeque和LinkedList。
         *
         *
         * // 不推荐的写法:
         * LinkedList<String> d1 = new LinkedList<>();
         * d1.offerLast("z");
         * // 推荐的写法：
         * Deque<String> d2 = new LinkedList<>();
         * d2.offerLast("z");
         *
         * 可见面向抽象编程的一个原则就是：尽量持有接口，而不是具体的实现类。
         *
         *
         * @小结
         * Deque实现了一个双端队列（Double Ended Queue），它可以：
         *
         *  - 将元素添加到队尾或队首：addLast()/offerLast()/addFirst()/offerFirst()；
         *  - 从队首／队尾获取元素并删除：removeFirst()/pollFirst()/removeLast()/pollLast()；
         *  - 从队首／队尾获取元素但不删除：getFirst()/peekFirst()/getLast()/peekLast()；
         *  - 总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开；
         *  - 避免把null添加到队列。
         */






    }
}
