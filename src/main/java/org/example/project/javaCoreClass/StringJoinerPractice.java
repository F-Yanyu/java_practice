package org.example.project.javaCoreClass;

import java.util.StringJoiner;

public class StringJoinerPractice {
    public static void main(String[] args){
        /**
         * @StringJoiner
         * 类似用分隔符拼接数组的需求很常见，所以Java标准库还提供了一个StringJoiner来干这个事：
         */
        String[] names = {"Bob", "Alice", "Grace"};
        // var sj = new StringJoiner(", ");
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        /*
        String.join(静态）
        String还提供了一个静态方法join()，这个方法在内部使用了StringJoiner来拼接字符串，在不需要指定“开头”和“结尾”的时候，用String.join()更方便：

         */

        String[] otherNames = {"Bob", "Alice", "Grace"};
        var s = String.join(", ", otherNames);
        System.out.println("otherNames:"+s);

        /**
         * practice
         * 请使用StringJoiner构造一个SELECT语句：
         */
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");

    }

    static String buildSelectSql(String table, String[] fields) {
        // TODO:
        var s = new StringJoiner(", ","SELECT "," FROM "+table);
        for(String i : fields){
            s.add(i);
        }
        return s.toString();
    }
}
