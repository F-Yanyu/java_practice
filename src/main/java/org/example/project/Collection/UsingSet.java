package org.example.project.Collection;

import java.util.HashSet;
import java.util.Set;

public class UsingSet {
    public static void main(String[] args) {
        /**
         * @使用Set
         * 只需要存储不重复的key，并不需要存储映射的value，那么就可以使用Set
         *
         * Set用于存储不重复的元素集合，它主要提供以下几个方法：
         *      将元素添加进Set<E>：boolean add(E e)
         *      将元素从Set<E>删除：boolean remove(Object e)
         *      判断是否包含元素：boolean contains(Object e)
         *
         * Set实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素。
         *
         * Set接口并不保证有序，而SortedSet接口则保证元素是有序的：
         *      - HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
         *      - TreeSet是有序的，因为它实现了SortedSet接口。
         *
         * 使用TreeSet和使用TreeMap的要求一样，添加的元素必须正确实现Comparable接口，如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象。
         *
         */
        /*
        我们来看几个简单的例子：
         */
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true
        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在
        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素
    }
}
