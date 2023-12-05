package org.example.project.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamPractice {
    public static void main(String[] args) throws IOException {
        /**
         * @InputStream
         * InputStream就是Java标准库提供的最基本的输入流。它位于java.io这个包里。java.io包提供了所有同步IO的功能。
         *
         * 要特别注意的一点是，InputStream并不是一个接口，而是一个抽象类，它是所有输入流的超类。这个抽象类定义的一个最重要的方法就是int read()，签名如下：
         *   public abstract int read() throws IOException;
         * 这个方法会读取输入流的下一个字节，并返回字节表示的int值（0~255）。如果已读到末尾，返回-1表示不能继续读取了。
         *
         */
        readFile();

        /**
         * @缓冲
         * InputStream提供了两个重载方法来支持读取多个字节：
         *   int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
         *   int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数
         * 利用上述方法一次读取多个字节时，需要先定义一个byte[]数组作为缓冲区，read()方法会尽可能多地读取字节到缓冲区， 但不会超过缓冲区的大小。read()方法的返回值不再是字节的int值，而是返回实际读取了多少个字节。如果返回-1，表示没有更多的数据了。
         */
// 利用缓冲区一次读取多个字节的代码如下：
//        try (InputStream input = new FileInputStream("src/readme.txt")) {
//            // 定义1000个字节大小的缓冲区:
//            byte[] buffer = new byte[1000];
//            int n;
//            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
//                System.out.println("read " + n + " bytes.");
//            }
//        }


        /**
         * @阻塞
         * 在调用InputStream的read()方法读取数据时，我们说read()方法是阻塞（Blocking）的。它的意思是，对于下面的代码：
         *   int n;
         *   n = input.read(); // 必须等待read()方法返回才能执行下一行代码
         *   int m = n;
         * 执行到第二行代码时，必须等read()方法返回后才能继续。因为读取IO流相比执行普通代码，速度会慢很多，因此，无法确定read()方法调用到底要花费多长时间。
         */

        /**
         * @InputStream实现类
         * 用FileInputStream可以从文件获取输入流，这是InputStream常用的一个实现类。此外，ByteArrayInputStream可以在内存中模拟一个InputStream：
         *
         * 这就是面向抽象编程原则的应用：接受InputStream抽象类型，而不是具体的FileInputStream类型，从而使得代码可以处理InputStream的任意实现类。
         */

        /**
         * @小结
         * Java标准库的java.io.InputStream定义了所有输入流的超类：
         *
         * FileInputStream实现了文件流输入；
         *
         * ByteArrayInputStream在内存中模拟一个字节流输入。
         *
         * 总是使用try(resource)来保证InputStream正确关闭。
         */

    }

    static void readFile() throws IOException {
        // 我们需要用try ... finally来保证InputStream在无论是否发生IO错误的时候都能够正确地关闭：
        InputStream input = null;
        try {
            input = new FileInputStream("D:\\file\\.txt\\javaFileTest.txt");
            int n;
            while ((n = input.read()) != -1) {  // 利用while同时读取并判断
                System.out.println(n);
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }

        // java 7引入的新的try(resource)语法，只需要编写try语句，让编译器自动为我们关闭资源。
//        try(InputStream input = new FileInputStream("D:\\file\\.txt\\javaFileTest.txt")){
//            int n;
//            while((n = input.read())!= -1){
//                System.out.println(n);
//            }
//        } // 编译器在此自动为我们写入finally并调用close()
        /*
        实际上，编译器并不会特别地为InputStream加上自动关闭。编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，如果实现了，就自动加上finally语句并调用close()方法。InputStream和OutputStream都实现了这个接口，因此，都可以用在try(resource)中。
         */

    }
}
