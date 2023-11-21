package org.example.project.javaCoreClass;

import java.math.BigInteger;

public class BigIntegerPractice {
    public static void main(String[] args) {
        /**
         * @BigInteger
         * java.math.BigInteger就是用来表示任意大小的整数。
         * BigInteger内部用一个int[]数组来模拟一个非常大的整数：
         * BigInteger bi = new BigInteger("1234567890");
         *      System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000
         */

        /*
        对BigInteger做运算的时候，只能使用实例方法，例如，加法运算：
        和long型整数运算比，BigInteger不会有范围限制，但缺点是速度比较慢。
         */
        BigInteger i1 = new BigInteger("1234567890000");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780

        /*
        也可以把BigInteger转换成long型：
        使用longValueExact()方法时，如果超出了long型的范围，会抛出ArithmeticException。
         */
        long a = i1.longValue();
        System.out.println(i1.longValue()); // 123456789000
//        System.out.println(i1.multiply(i1).longValueExact()); // java.lang.ArithmeticException: BigInteger out of long range

        /*
        @转换
        BigInteger和Integer、Long一样，也是不可变类，并且也继承自Number类。因为Number定义了转换为基本类型的几个方法：
        转换为byte：byteValue()
        转换为short：shortValue()
        转换为int：intValue()
        转换为long：longValue()
        转换为float：floatValue()
        转换为double：doubleValue()
        因此，通过上述方法，可以把BigInteger转换成基本类型。如果BigInteger表示的范围超过了基本类型的范围，转换时将丢失高位信息，
        即结果不一定是准确的。如果需要准确地转换成基本类型，可以使用intValueExact()、longValueExact()等方法，在转换时如果超出范围，将直接抛出ArithmeticException异常。
         */
        BigInteger n = new BigInteger("999999").pow(99);
        float f = n.floatValue();
        System.out.println(f); // Infinity

        /**
         * @小结
         * BigInteger用于表示任意大小的整数；
         * BigInteger是不变类，并且继承自Number；
         * 将BigInteger转换成基本类型时可使用longValueExact()等方法保证结果准确。
         */
    }
}
