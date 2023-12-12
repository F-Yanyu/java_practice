package org.example.project.RegularExpression;

public class ComplexMatchesRule {
    public static void main(String[] args) {
        /**
         * @复杂匹配规则
         */

        /**
         * @匹配开头和结尾
         * 用正则表达式进行多行匹配时，我们用^表示开头，$表示结尾。例如，^A\d{3}$，可以匹配"A001"、"A380"。
         */

        /**
         * @匹配指定范围
         *
         * 使用[...]可以匹配范围内的字符，例如，[123456789]可以匹配1~9，这样就可以写出上述电话号码的规则：[123456789]\d{6,7}。
         * 可以直接改成[1-9]
         *
         * 要匹配大小写不限的十六进制数，比如1A2b3c，我们可以这样写：[0-9a-fA-F]，它表示一共可以匹配以下任意范围的字符：
         * 0-9：字符0~9；
         * a-f：字符a~f；
         * A-F：字符A~F。
         *
         * [...]还有一种排除法，即不包含指定范围的字符。假设我们要匹配任意字符，但不包括数字，可以写[^1-9]{3}：
         */

        /**
         * @或规则匹配
         * 用|连接的两个正则规则是或规则，例如，AB|CD表示可以匹配AB或CD。
         */

        /**
         * @使用括号
         * 现在我们想要匹配字符串learn java、learn php和learn go怎么办？一个最简单的规则是learn\sjava|learn\sphp|learn\sgo，但是这个规则太复杂了，可以把公共部分提出来，然后用(...)把子规则括起来表示成learn\\s(java|php|go)。
         */
        String re = "learn\\s(java|php|go|Java|Php|Go)";
        System.out.println("learn java".matches(re));
        System.out.println("learn Java".matches(re));


    }
}
