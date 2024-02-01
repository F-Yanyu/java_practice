package org.example.project.Multithreading;

public class UsingThreadLocal {
    public static void main(String[] args) {
        /**
         * @使用ThreadLocal
         *
         * 小结
         * ThreadLocal表示线程的“局部变量”，它确保每个线程的ThreadLocal变量都是各自独立的；
         *
         * ThreadLocal适合在一个线程的处理流程中保持上下文（避免了同一参数在所有方法中传递）；
         *
         * 使用ThreadLocal要用try ... finally结构，并在finally中清除。
         */
    }
}
