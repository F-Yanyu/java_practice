package org.example.project.Collection;

public class UsingIterator {
    public static void main(String[] args) {
        /**
         * @使用Iterator
         *
         * 如果我们自己编写了一个集合类，想要使用for each循环，只需满足以下条件：
         *
         * 集合类实现Iterable接口，该接口要求返回一个Iterator对象；
         * 用Iterator对象迭代集合内部数据。
         * 这里的关键在于，集合类通过调用iterator()方法，返回一个Iterator对象，这个对象必须自己知道如何遍历该集合。
         *
         *
         */

        // 一个简单的Iterator示例如下，它总是以倒序遍历集合：


        /**
         * @小结
         * Iterator是一种抽象的数据访问模型。使用Iterator模式进行迭代的好处有：
         *
         * 对任何集合都采用同一种访问模型；
         * 调用者对集合内部结构一无所知；
         * 集合类返回的Iterator对象知道如何迭代。
         * Java提供了标准的迭代器模型，即集合类实现java.util.Iterable接口，返回java.util.Iterator实例。
         *
         */
    }
}
