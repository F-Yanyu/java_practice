package org.example.project.javaCoreClass;

//import java.util.HexFormat;
import java.util.Random;

import java.util.Arrays;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

public class CommonUtilsClass {
    public static void main(String[] args) {
        /**
         * 常用工具类
         * Math
         */

        /*
        求绝对值：
         */
        System.out.println(Math.abs(-100));// 100
        System.out.println(Math.abs(-7.8));// 7.8

        /*
        取最大或最小值
         */
        System.out.println(Math.max(100,99));
        System.out.println(Math.min(1.2, 2.3)); // 1.2;

        /*
        计算x的y次方：
         */
        System.out.println(Math.pow(2,10));// 2的10次方=1024

        /*
        计算计算√x：
         */
        Math.sqrt(2); // 1.414...

        /*
        计算ex次方：
         */
        Math.exp(2); // 7.389...

        /*
        计算以e为底的对数：
         */
        Math.log(4); // 1.386...

        /*
        计算以10为底的对数
         */
        Math.log10(100); // 2

        /*
        三角函数：
         */
        Math.sin(3.14); // 0.00159...
        Math.cos(3.14); // -0.9999...
        Math.tan(3.14); // -0.0015...
        Math.asin(1.0); // 1.57079...
        Math.acos(1.0); // 0.0

        /*
        Math还提供了几个数学常量：
         */
        double pi = Math.PI; // 3.14159...
        double e = Math.E; // 2.7182818...
        Math.sin(Math.PI / 6); // sin(π/6) = 0.5

        /*
        生成一个随机数x，x的范围是0 <= x < 1：
         */
        Math.random(); // 0.53907... 每次都不一样

        /*
        如果我们要生成一个区间在[MIN, MAX)的随机数，可以借助Math.random()实现，计算如下：
         */
        // 区间【MIN,Max】的随机数
        double x = Math.random(); // x的范围是[0,1)
        double min = 10;
        double max = 50;
        double y = x * (max - min) + min; // y的范围是[10,50)
        long n = (long) y; // n的范围是[10,50)的整数
        System.out.println(y);
        System.out.println(n);

        /*
        @HexFormat
        在处理byte[]数组时，我们经常需要与十六进制字符串转换，自己写起来比较麻烦，
            用Java标准库提供的HexFormat则可以方便地帮我们转换。
        要将byte[]数组转换为十六进制字符串，可以用formatHex()方法：
         */
//        byte[] data = "Hello".getBytes();
//        HexFormat hf = HexFormat.of();
//        String hexData = hf.formatHex(data); // 48656c6c6f

        /*
        如果要定制转换格式，则使用定制的HexFormat实例：
         */
        // 分隔符为空格，添加前缀0x，大写字母:
//        HexFormat hfe = HexFormat.ofDelimiter(" ").withPrefix("0x").withUpperCase();
//        hfe.formatHex("Hello".getBytes()); // 0x48 0x65 0x6C 0x6C 0x6F

        /*
        从十六进制字符串到byte[]数组转换，使用parseHex()方法：
         */
//        byte[] bs = HexFormat.of().parseHex("48656c6c6f");


        /*
        Random
        Random用来创建伪随机数。所谓伪随机数，是指只要给定一个初始的种子，产生的随机数序列是完全一样的。
        这是因为我们创建Random实例时，如果不给定种子，就使用系统当前时间戳作为种子，因此每次运行时，种子不同，得到的伪随机数序列就不同。
        如果我们在创建Random实例时指定一个种子，就会得到完全确定的随机数序列：
         */
        Random r = new Random();
        r.nextInt(); // 2071575453,每次都不一样
        r.nextInt(10); // 5,生成一个[0,10)之间的int
        r.nextLong(); // 8811649292570369305,每次都不一样
        r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
        r.nextDouble(); // 0.3716...生成一个[0,1)之间的double


        Random ra = new Random(12345);
        for(int i = 0; i < 10;i++){
            System.out.println(ra.nextInt(100));
        }

        /*
        SecureRandom
        有伪随机数，就有真随机数。实际上真正的真随机数只能通过量子力学原理来获取，而我们想要的是一个不可预测的安全的随机数，
        SecureRandom就是用来创建安全的随机数的：
         */
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException err) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
        /**
         * @安全
         * SecureRandom的安全性是通过操作系统提供的安全的随机种子来生成随机数。这个种子是通过CPU的热噪声、读写磁盘的字节、网络流量等各种随机事件产生的“熵”。
         * 在密码学中，安全的随机数非常重要。如果使用不安全的伪随机数，所有加密体系都将被攻破。因此，时刻牢记必须使用SecureRandom来产生安全的随机数。
         */

        /**
         * @小结
         * Java提供的常用工具类有：
         * Math：数学计算
         * Random：生成伪随机数
         * SecureRandom：生成安全的随机数
         */
    }
}
