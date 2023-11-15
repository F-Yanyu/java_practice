package org.example.project.array;

public class PracticeArr01 {
    public static void main(String[] srgs) {
        /*
        创建一个char类型的26个元素的数组，分别 放置'A'-z使用for循环访问所有元素并打印出来。
        提示 : char类型数据运算A'+2 ->cIgf
         */

        char[] englishZi = new char[26];
        for (int i = 0; i < englishZi.length; i++) {
            englishZi[i] = (char) ('A' + i);// 'A' + i 是 int 类型，需要强制转换。
            System.out.println("元素" + (i + 1) + "是" + englishZi[i]);
        }

    }
}
