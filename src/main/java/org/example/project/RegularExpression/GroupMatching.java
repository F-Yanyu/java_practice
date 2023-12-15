package org.example.project.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupMatching {
    public static void main(String[] args) {
        /**
         * @分组匹配
         *
         */

        // 练习
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if(m.matches()){
            String s1 = m.group(1);
            String s2 = m.group(2);
            System.out.println("s1："+s1+"s2:"+s2);
        } else {
            System.out.println("匹配失败");
        }
        /*
        要特别注意，Matcher.group(index)方法的参数用1表示第一个子串，2表示第二个子串。如果我们传入0会得到什么呢？答案是010-12345678，即整个正则匹配到的字符串。
        */


        // 但是反复使用String.matches()对同一个正则表达式进行多次匹配效率较低，因为每次都会创建出一样的Pattern对象。完全可以先创建出一个Pattern对象，然后反复使用，就可以实现编译一次，多次匹配：
        Pattern p1 = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        System.out.println(p1.matcher("101-10101000").matches());
        System.out.println(p1.matcher("11-10101000").matches());
        System.out.println(p1.matcher("101-10101000").matches());

        // 获取matcher对象
        Matcher m1 = p1.matcher("123-12345678");
        if(m1.matches()){
            System.out.println(m1.group(0));//123-12345678
            System.out.println(m1.group(1));//123
            System.out.println(m1.group(2));//12345678
            /*
            使用Matcher时，必须首先调用matches()判断是否匹配成功，匹配成功后，才能调用group()提取子串。
            利用提取子串的功能，我们轻松获得了区号和号码两部分。
             */
        }
    }
}
