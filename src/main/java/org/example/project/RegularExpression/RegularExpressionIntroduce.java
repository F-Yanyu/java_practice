package org.example.project.RegularExpression;

public class RegularExpressionIntroduce {
    public static void main(String[] args) {
        /**
         * @正则表达式简洁
         *
         * @小结
         * 正则表达式是用字符串描述的一个匹配规则，使用正则表达式可以快速判断给定的字符串是否符合匹配规则。Java标准库java.util.regex内建了正则表达式引擎。
         */
        // 判断字符串是否是20##年
        String regex = "20\\d\\d";
        System.out.println("2019".matches(regex)); // true
        System.out.println("2100".matches(regex)); // false

    }
}
