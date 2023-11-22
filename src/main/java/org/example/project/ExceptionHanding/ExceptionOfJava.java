package org.example.project.ExceptionHanding;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ExceptionOfJava {
    public static void main(String[] args) {
        /**
         * Java的异常
         */
//        String s = "abc";
//        int n = Integer.parseInt(s); // NumberFormatException!

        /*
        程序想要读写某个文件的内容，但是用户已经把它删除了：
         */
        // String t = readFile("C:\\abc.txt");

        /*
        @捕获异常
         */
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));


        /**
         * 先记录下来
         * 所有异常都可以调用printStackTrace()方法打印异常栈，这是一个简单有用的快速打印异常的方法。
         *
         * static byte[] toGBK(String s){
         *  try{
         *      return s.getBytes("GBK");
         *  } catch(UnsupportedEncodingException e) {
         *      e.printStackTrace();
         *  }
         * }
         */

        /**
         * @小结
         * Java使用异常来表示错误，并通过try ... catch捕获异常；
         *
         * Java的异常是class，并且从Throwable继承；
         *
         * Error是无需捕获的严重错误，Exception是应该捕获的可处理的错误；
         *
         * RuntimeException无需强制捕获，非RuntimeException（Checked Exception）需强制捕获，或者用throws声明；
         *
         * 不推荐捕获了异常但不进行任何处理。
         */


    }

    static byte[] toGBK(String s) {
        try {
            // 用指定编码转换String为byte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
            System.out.println("异常" + e); // 打印异常信息
            return s.getBytes(); // 尝试使用用默认编码
        }
    }
}
