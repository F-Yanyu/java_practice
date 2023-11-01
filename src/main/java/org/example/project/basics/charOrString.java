package org.example.project.basics;

public class charOrString {
    public static void main(String[] args) {
/**
 * @charOrString 字符和字符串
 *  一个char保存一个unicode字符,显示一个字符的unicode编码只需要将char直接赋值给int类型
 */
        int a = '中';
        System.out.println(a);

//        用转义字符 \\u+Unicode编码来表示一个字符
        char b = '\u4e2d';
        System.out.println(b);


//        String ,引用类型
        /**
         * \" 表示字符"
         * \' 表示字符'
         * \\ 表示字符\
         * \n 表示换行符
         * \r 表示回车符
         * \t 表示Tab
         * \\u#### 表示一个Unicode编码的字符
         */

//        多行字符串 java13才有"""..."""


//        不可变性
        String s = "hello";
        String t = s;
        s = "world";
        System.out.println(t); //=> 字符串的不可变是指字符串内容不可变,只是指向变了。

        practice();
    }

// 练习
    public static void practice()
    {
        // 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
        int a = 72;
        int b = 105;
        int c = 65281;
        char a1 = (char)a;
        char a2 = (char)b;
        char a3 = (char)c;
        // FIXME:
        String s = String.valueOf(a1 + a2 + a3);
        System.out.println(s);
    }
}
