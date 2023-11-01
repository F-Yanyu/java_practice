package org.example.project.processControl;
import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        // println是print line的缩写，表示输出并换行，下面试一下不换行的print
        System.out.print("A,");
        System.out.print("B,");
        System.out.print("C.");
        System.out.println();
        System.out.println("END");

        // 格式化输出 printf,通过使用占位符%?，printf()可以把后面的参数格式化成指定格式：
        double d = 3.1415926;
        System.out.printf("%.2f\n", d); // 显示两位小数3.14
        System.out.printf("%.4f\n", d); // 显示4位小数3.1416
        // 其中提供了多种格式化功能占位符
        /**
         * %d	格式化输出整数
         * %x	格式化输出十六进制整数
         * %f	格式化输出浮点数
         * %e	格式化输出科学计数法表示的浮点数
         * %s	格式化字符串
         */
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数


        // 输入
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.println("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }
}
