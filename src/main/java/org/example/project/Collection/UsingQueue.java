package org.example.project.Collection;

import java.util.LinkedList;
import java.util.Queue;

public class UsingQueue {
    public static void main(String[] args) {
        /**
         * @使用Queue 队列（Queue）是一种经常使用的集合。
         * Queue实际上是实现了一个先进先出（FIFO：First In First Out）的有序表。它和List的区别在于，List可以在任意位置添加和删除元素，而Queue只有两个操作：
         *      - 把元素添加到队列末尾；
         *      - 从队列头部取出元素。
         *
         * 在Java的标准库中，队列接口Queue定义了以下几个方法：
         *      - int size()：获取队列长度；
         *      - boolean add(E)/boolean offer(E)：添加元素到队尾；
         *      - E remove()/E poll()：获取队首元素并从队列中删除；
         *      - E element()/E peek()：获取队首元素但并不从队列中删除。
         * 注意：不要把null添加到队列中，否则poll()方法返回null时，很难确定是取到了null元素还是队列为空。
         *
         *
         * @小结
         * 队列Queue实现了一个先进先出（FIFO）的数据结构：
         *  - 通过add()/offer()方法将元素添加到队尾；
         *  - 通过remove()/poll()从队首获取元素并删除；
         *  - 通过element()/peek()从队首获取元素但不删除。
         * 要避免把null添加到队列。
         */

        Queue<String> q = new LinkedList<>();
        q.offer("apple");
        q.offer("banana");
        q.offer("pear");
        System.out.println(q.peek());
        System.out.println(q.peek());// 可以重复获取因为peek()不会删除
        System.out.println(q.poll());
        System.out.println(q.poll());// 获取后删除
    }
}
