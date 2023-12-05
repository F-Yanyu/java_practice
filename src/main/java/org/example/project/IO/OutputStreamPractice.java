package org.example.project.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamPractice {
    public static void main(String[] args) throws IOException {
        /**
         * @OutStream
         * 和InputStream相反，OutputStream是Java标准库提供的最基本的输出流。
         * 和InputStream类似，OutputStream也是抽象类，它是所有输出流的超类。这个抽象类定义的一个最重要的方法就是void write(int b)，签名如下：
         *   public abstract void write(int b) throws IOException;
         *
         * OutputStream也提供了close()方法关闭输出流，以便释放系统资源。要特别注意：OutputStream还提供了一个flush()方法，它的目的是将缓冲区的内容真正输出到目的地。
         *
         */

        /**
         * @FileOutputStream
         *
         */
        try (OutputStream output = new FileOutputStream("D:/file/.txt/out/readme.txt")) {
            output.write("Hello!!!My name is FuYanyu".getBytes("UTF-8")); // Hello
        } // 编译器在此自动为我们写入finally并调用close()


        /**
         * @阻塞
         * 和InputStream一样，OutputStream的write()方法也是阻塞的。
         */

        /**
         * @OutputStream实现类
         * 用FileOutputStream可以从文件获取输出流，这是OutputStream常用的一个实现类。此外，ByteArrayOutputStream可以在内存中模拟一个OutputStream：
         *
         * ByteArrayOutputStream实际上是把一个byte[]数组在内存中变成一个OutputStream，虽然实际应用不多，但测试的时候，可以用它来构造一个OutputStream。
         * 同时操作多个AutoCloseable资源时，在try(resource) { ... }语句中可以同时写出多个资源，用;隔开。例如，同时读写两个文件：
         */


        /**
         * @小结
         * Java标准库的java.io.OutputStream定义了所有输出流的超类：
         *
         * FileOutputStream实现了文件流输出；
         *
         * ByteArrayOutputStream在内存中模拟一个字节流输出。
         *
         * 某些情况下需要手动调用OutputStream的flush()方法来强制输出缓冲区。
         *
         * 总是使用try(resource)来保证OutputStream正确关闭。
         */



    }
}
