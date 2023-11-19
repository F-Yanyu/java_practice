package org.example.project.javaCoreClass;


public class StringBuilderPractice {
    public static void main(String[] args){
        /**
         * @StringBuilder
         * StringBuilder是可变对象，用来高效拼接字符串；
         *
         * StringBuilder可以支持链式操作，实现链式操作的关键是返回实例本身；
         *
         * StringBuffer是StringBuilder的线程安全版本，现在很少使用。
         */

        var sb = new StringBuilder(1024);
        sb.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb.toString());

        var a = new StringBuilder(1024);
        int a1 = 1000;
        for(int i = 0; i < a1;i++){
            a.append(i);
        }
        System.out.println(a.toString());
    }
}
