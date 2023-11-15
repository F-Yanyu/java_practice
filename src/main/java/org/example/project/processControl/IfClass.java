package org.example.project.processControl;

public class IfClass {
    public static void main(String[] args) {
        // if语句判断范围从大到小判断或者改写成从小到大依次判断：使用if时，还要特别注意边界条件


        // 正确的方法是利用差值小于某个临界值来判断：
        double x = 1 - 9.0 / 10;
        if (Math.abs(x - 0.1) < 0.00001) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }


        // 判断引用类型是否相等，必须使用equals()方法：
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }
        // 执行语句s1.equals(s2)时，如果变量s1为null，会报NullPointerException：
        // 要避免NullPointerException错误，可以利用短路运算符&&：
//        if (s1 != null && s1.equals("hello")) {
//            System.out.println("hello");
//        }

    }
}
