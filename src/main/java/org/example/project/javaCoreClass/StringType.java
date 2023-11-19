package org.example.project.javaCoreClass;

public class StringType {
    public static void main(String[] args){
        /**
         * @String
         *
         * 比较两个字符串内容相容必须使用equals方法，而不能使用"=="
         */
        String s = "Hello";
        System.out.println(s); //=> Hello
        s = s.toUpperCase();
        System.out.println(s); //=> HELLO
        // 根据上面代码的输出，试解释字符串内容是否改变。
        // 字符串其实没有改变，只是引用地址变了。

        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        // 从表面上看，两个字符串用==和equals()比较都为true，但实际上那只是Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，自然s1和s2的引用就是相同的。
        // 所以，这种==比较返回true纯属巧合。换一种写法，==比较就会失败：
        String s3 = "hello";
        String s4 = "HELLO".toLowerCase();
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        // 结论：两个字符串比较，必须总是使用equals()方法。
        // 要忽略大小写比较，使用equalsIgnoreCase()方法。

        // 提取“子串”使用："Hello".contains("ll"); // true
        // 更多栗子
        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true

        // 提取子串的例子：
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); // "ll"
        // 注意索引号是从0开始的。


        /*
        去除首尾空白字符
        使用trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n：
        注意：trim()并没有改变字符串的内容，而是返回了一个新字符串。
         */

        "  \tHello\r\n ".trim(); // "Hello"

        /*
        另一个strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
         */
        "\u3000Hello\u3000".strip(); // "Hello"
        " Hello ".stripLeading(); // "Hello "
        " Hello ".stripTrailing(); // " Hello"

        /*
        String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
         */
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        /*
        替换子串
         */
        // 要在字符串中替换子串，有两种方法。一种是根据字符或字符串替换：
        String s11 = "hello";
        s11.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s11.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
        // 另一种是通过正则表达式替换：
        String s12 = "A,,B;C ,D";
        s12.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
        // 上面的代码通过正则表达式，把匹配的子串统一替换为","

        /*
        分割字符串
        要分割字符串，使用split()方法，并且传入的也是正则表达式：
        String s = "A,B,C,D";
        String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
         */

        /*
        拼接字符串
        拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组：
        String[] arr = {"A", "B", "C"};
        String s = String.join("***", arr); // "A***B***C"
         */

        /*
        格式化字符串
        字符串提供了formatted()方法和format()静态方法，可以传入其他参数，替换占位符，然后生成新的字符串：String s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
         */

        /*
        类型转换
        要把任意基本类型或引用类型转换为字符串，可以使用静态方法valueOf()。这是一个重载方法，编译器会根据参数自动选择合适的方法：
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c
         */

        /*
        String 转 int
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

        要特别注意，Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
        Integer.getInteger("java.version"); // 版本号，11
         */

        /*
        String 转 布尔
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false
         */

        /*
        String 转 char[]
        String和char[]类型可以互相转换，方法是：
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s = new String(cs); // char[] -> String
        如果修改了char[]数组，String并不会改变：
         */

        /*
        字符编码
        在Java中，char类型实际上就是两个字节的Unicode编码。如果我们要手动把字符串转换成其他编码，可以这样做：
        byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
        byte[] b2 = "Hello".getBytes("GBK"); // 按GBK编码转换
        byte[] b3 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
        注意：转换编码后，就不再是char类型，而是byte类型表示的数组。

        如果要把已知编码的byte[]转换为String，可以这样做：
        byte[] b = ...
        String s1 = new String(b, "GBK"); // 按GBK转换
        String s2 = new String(b, StandardCharsets.UTF_8); // 按UTF-8转换
        始终牢记：Java的String和char在内存中总是以Unicode编码表示。
         */


        /**
         * @小结
         * Java字符串String是不可变对象；
         *
         * 字符串操作不改变原字符串内容，而是返回新字符串；
         *
         * 常用的字符串操作：提取子串、查找、替换、大小写转换等；
         *
         * Java使用Unicode编码表示String和char；
         *
         * 转换编码就是将String和byte[]转换，需要指定编码；
         *
         * 转换为byte[]时，始终优先考虑UTF-8编码。
         */

    }
}
