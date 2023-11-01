package org.example.project.basics;

public class BooleanClass {
    public static void main(String[] args) {
        boolean isReal = 5 > 10;
        System.out.println(isReal);

//        关系运算符的优先级是
        /*
        !、 >、 >=、 <、 <=、 ==、 !=、 &&、 ||
         */

//        短路运算
        boolean b = 5 < 3;
        boolean result = b && (5 / 0 > 0);
        System.out.println(result);

//        三元运算符
    }
}
