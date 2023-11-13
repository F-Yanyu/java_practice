package org.example.project.array;

import java.util.Scanner;

public class initArray {
    public static void main(String[] args) {

        /**
         * @数组初始化
         * int[] a = new int[3] 等价于 int a[] = int[3]
         */

        /*
        动态初始化
         */

        // 循环输入5个成绩，保存到double类型数组中，然后输出
        double[] scores = new double[5];
        Scanner myScanner = new Scanner(System.in);
        for(int i = 0; i < scores.length; i++){
            System.out.println("请输入第" + (i+1) + "个元素的值");
            scores[i] = myScanner.nextDouble();
        }

        // 输出
        for(int i = 0; i < scores.length; i++){
            System.out.println("第"+(i+1)+"个元素是:"+scores[i]);
        }


        /*
        静态初始化
         */

        int[] a = {1,2,3,4,56};
    }
}
