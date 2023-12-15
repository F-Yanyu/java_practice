package org.example.project.RegularExpression;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchAndReplace {
    public static void main(String[] args) {
        /**
         * @搜索和替换
         *
         */
        /*
        分割字符串
         */
        String[] a = "a b c".split("\\s");
        System.out.println(Arrays.toString(a));
        "a b  c".split("\\s"); // { "a", "b", "", "c" }
        "a, b ;; c".split("[\\,\\;\\s]+"); // { "a", "b", "c" }

        /**
         * 搜索字符串
         *
         */
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }

        String name = "fuyanyu";
        System.out.println(name.substring(2));


        /**
         * @替换字符串
         */
        String s2 = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String s3 = s2.replaceAll("\\s+"," ");
        System.out.println(s3);
        // 上面的代码把不规范的连续空格分隔的句子变成了规范的句子。可见，灵活使用正则表达式可以大大降低代码量。

        /**
         * @反向引用
         * 如果我们要把搜索到的指定字符串按规则替换，比如前后各加一个<b>xxxx</b>，这个时候，使用replaceAll()的时候，我们传入的第二个参数可以使用$1、$2来反向引用匹配到的子串。
         */
        String s4 = "the quick brown fox jumps over the lazy dog.";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
        // 它实际上把任何4字符单词的前后用<b>xxxx</b>括起来。实现替换的关键就在于" <b>$1</b> "，它用匹配的分组子串([a-z]{4})替换了$1。


        /**
         * @练习
         *
         * @小结
         * 使用正则表达式可以：
         *      分割字符串：String.split()
         *      搜索子串：Matcher.find()
         *      替换字符串：String.replaceAll()
         */
    }
}
