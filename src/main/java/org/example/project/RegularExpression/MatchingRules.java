package org.example.project.RegularExpression;

import java.util.List;

public class MatchingRules {
    public static void main(String[] args) {
        /**
         * @匹配规则
         * 正则表达式的匹配规则是从左到右按规则匹配。
         *
         * 如果想匹配非ASCII字符，例如中文，那就用\\u####的十六进制表示，例如：a\u548cc匹配字符串"a和c"，中文字符和的Unicode编码是548c。
         */

        String re1 = "abc";
        System.out.println("abc".matches(re1)); // true
        System.out.println("Abc".matches(re1)); // false
        System.out.println("abcd".matches(re1)); // false

        String re2 = "a\\&c"; // 对应的正则是a\&c
        System.out.println("a&c".matches(re2)); // true
        System.out.println("a-c".matches(re2)); // false
        System.out.println("a&&c".matches(re2)); // false

        /**
         * @匹配任意字符
         * 我们可以用.匹配一个任意字符。
         * 但它不能匹配"ac"、"a&&c"，因为.匹配一个字符且仅限一个字符。
         */
        String re3 = "a.c";
        System.out.println("==========任意字符==========");
        System.out.println("acc".matches(re3)); // true
        System.out.println("a&c".matches(re3)); // true
        System.out.println("a&&c".matches(re3)); // false


        /**
         * @匹配数字
         * 匹配0~9这样的数字，可以用\d匹配
         * 仅限单个数字字符
         */
        String re4 = "1\\d3";
        System.out.println("========匹配数字=======");
        System.out.println("123".matches(re4));
        System.out.println("143".matches(re4));
        System.out.println("133".matches(re4));

        /**
         * @匹配常用字符
         * 用\w可以匹配一个字母、数字或下划线，w的意思是word。例如，java\w可以匹配：
         *
         * "javac"，因为\w可以匹配英文字符c；
         * "java9"，因为\w可以匹配数字字符9；。
         * "java_"，因为\w可以匹配下划线_。
         *
         * 它不能匹配"java#"，"java "，因为\w不能匹配#、空格等字符。
         *
         * \W可以匹配\w不能匹配的字符
         */
        String re5 = "java\\w";
        System.out.println("=========匹配常用字符==========");
        System.out.println("javac".matches(re5));
        System.out.println("java9".matches(re5));
        System.out.println("java_".matches(re5));


        /**
         * @匹配空格字符
         * 用\s可以匹配一个空格字符，注意空格字符不但包括空格，还包括tab字符（在Java中用\t表示）。例如，a\sc可以匹配：
         * "a c"，因为\s可以匹配空格字符；
         * "a c"，因为\s可以匹配tab字符\t。
         *
         * 它不能匹配"ac"，"abc"等。
         *
         * \S可以匹配\s不能匹配的字符
         */

        /**
         * @匹配非数字
         * 用\d可以匹配一个数字，而\D则匹配一个非数字。例如，00\D可以匹配：
         * "00A"，因为\D可以匹配非数字字符A；
         * "00#"，因为\D可以匹配非数字字符#。
         */

        /**
         * @重复匹配
         * 修饰符*可以匹配任意个字符，包括0个字符。我们用A\d*可以匹配：
         *
         * A：因为\d*可以匹配0个数字；
         * A0：因为\d*可以匹配1个数字0；
         * A380：因为\d*可以匹配多个数字380。
         * 修饰符+可以匹配至少一个字符。我们用A\d+可以匹配：
         *
         * A0：因为\d+可以匹配1个数字0；
         * A380：因为\d+可以匹配多个数字380。
         * 但它无法匹配"A"，因为修饰符+要求至少一个字符。
         *
         * 修饰符?可以匹配0个或一个字符。我们用A\d?可以匹配：
         *
         * A：因为\d?可以匹配0个数字；
         * A0：因为\d?可以匹配1个数字0。
         * 但它无法匹配"A33"，因为修饰符?超过1个字符就不能匹配了。
         *
         * 如果我们想精确指定n个字符怎么办？用修饰符{n}就可以。A\d{3}可以精确匹配：
         *
         * A380：因为\d{3}可以匹配3个数字380。
         * 如果我们想指定匹配n~m个字符怎么办？用修饰符{n,m}就可以。A\d{3,5}可以精确匹配：
         *
         * A380：因为\d{3,5}可以匹配3个数字380；
         * A3800：因为\d{3,5}可以匹配4个数字3800；
         * A38000：因为\d{3,5}可以匹配5个数字38000。
         *
         */

        /**
         * @练习
         * 请编写一个正则表达式匹配国内的电话号码规则：3~4位区号加7~8位电话，中间用-连接，例如：010-12345678。
         */
        String re6 = "\\d{3,4}-\\d{7,8}";

        System.out.println("=========练习=========");
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re6)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re6)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}
