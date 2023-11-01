package org.example.project.basics;

public class ArrayClass {
    public static void main(String[] args) {
        // 5 位同学的成绩
        int[] ns = new int[5]; // 指定数组大小
        ns[0] = 14;
        System.out.println(ns.length);

        // 直接指定初始化数组元素，这样就不用指定数组大小，编译器自动推算大小
        int[] bs = new int[]{1,3,4,5,6};
        System.out.println(bs.length);

        // 还可以简写为
        int[] cs = {1,3,4,5,6};
        System.out.println(cs.length);

        String[] names = {"xyz","zoo","fuyanyu"};
        String s = names[2];
        names[2] = "hello";
        System.out.println(s);
        System.out.println(names[4]);// 索引超过数组长度将报错。
    }
}
