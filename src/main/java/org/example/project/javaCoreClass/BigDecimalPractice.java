package org.example.project.javaCoreClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalPractice {
    public static void main(String[] args) {
        /**
         * @BigDecimal
         * BigDecimal可以表示一个任意大小且精度完全准确的浮点数。
         */
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489

        /*
        BigDecimal用scale()表示小数位数，例如：
         */
        BigDecimal b = new BigDecimal("3.1415926"); // 7
        System.out.println(b.scale());

        /*
        BigDecimal的stripTrailingZeros()方法，可以将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal：
        如果一个BigDecimal的scale()返回负数，例如，-2，表示这个数是个整数，并且末尾有2个0。
         */
        BigDecimal c = new BigDecimal("3.3340004000");
        System.out.println(c.stripTrailingZeros()); // 3.3340004

        /*
        @setScale
        可以对一个BigDecimal设置它的scale，如果精度比原始值低，
        那么按照指定的方法进行四舍五入或者直接截断：
        */
        BigDecimal d = new BigDecimal("123.456789");
        BigDecimal d1 = d.setScale(4, RoundingMode.HALF_UP);// 四舍五入，123.4568
        BigDecimal d2 = d.setScale(4,RoundingMode.DOWN); // 直接截断，123.4567
        System.out.println(d1);
        System.out.println(d2);

        /*
        对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断：
         */
        BigDecimal e1 = new BigDecimal("123.456");
        BigDecimal e2 = new BigDecimal("23.456789");
        BigDecimal e3 = e1.divide(e2, 10, RoundingMode.HALF_UP); // 保留10位小数并四舍五入
        BigDecimal e4 = e1.divide(e2); // 报错：ArithmeticException，因为除不尽

        // 还可以对BigDecimal做除法的同时求余数：
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105

        /*
         调用divideAndRemainder()方法时，返回的数组包含两个BigDecimal，分别是商和余数，其中商总是整数，余数不会大于除数。我们可以利用这个方法判断两个BigDecimal是否是整数倍数：
         BigDecimal n = new BigDecimal("12.75");
         BigDecimal m = new BigDecimal("0.15");
         BigDecimal[] dr = n.divideAndRemainder(m);
         if (dr[1].signum() == 0) {
            // n是m的整数倍
         }
         */

        /*
        比较BigDecimal
            System.out.println(d1.compareTo(d2)); // 0
        必须使用compareTo()方法来比较，它根据两个值的大小分别返回负数、正数和0，分别表示小于、大于和等于。
         */

        /*
        如果查看BigDecimal的源码，可以发现，实际上一个BigDecimal是通过一个BigInteger和一个scale来表示的，即BigInteger表示一个完整的整数，而scale表示小数位数：
        public class BigDecimal extends Number implements Comparable<BigDecimal> {
        private final BigInteger intVal;
        private final int scale;
        }
        BigDecimal也是从Number继承的，也是不可变对象。
         */

        /**
         * @小结
         * BigDecimal用于表示精确的小数，常用于财务计算；
         * 比较BigDecimal的值是否相等，必须使用compareTo()而不能使用equals()。
         */
    }
}
