package org.example.project.array;

import java.util.Arrays;

// 多维数组
public class MultidimensionalArray {
    public static void main(String[] args){
        // 定义二维数组，就是数组里面的数组
        int[][] ns = {
                {1,2,3},
                {1,3,3}
        };

        int[] a = ns[0];// 把其中一个数组赋值出来
//        System.out.println(Arrays.toString(a));

        /**
         * 打印二维数组
         * 使用两层嵌套for循环
         * java标准库方法Arrays.deepToString
         */
        // method 1
        for(int[] i : ns){
            for(int n : i){
                System.out.println(n);
            }
        }

        // method 2
        System.out.println(Arrays.deepToString(ns));

        /**
         * 三维数组：三维数组就是二维数组的数组。
         */
        int[][][] arrs = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11},
                        {12, 13}
                },
                {
                        {14, 15, 16},
                        {17, 18}
                }
        };


        /*
        使用二维数组可以表示一组学生的各科成绩，请计算所有学生的平均分：
         */

        // 用二维数组表示的学生成绩:
        int[][] scores = {
                { 82, 90, 91 },
                { 68, 72, 64 },
                { 95, 91, 89 },
                { 67, 52, 60 },
                { 79, 81, 85 },
        };
        // TODO:
        double average = 0;
        int students = 0;
        double totalGrade = 0;
        for(int i = 0;i < scores.length;i++){
            students += scores[i].length;
            for(int j = 0;j < scores[i].length;j++){
                totalGrade += scores[i][j];
            }
        }
        average = totalGrade / students;

        System.out.println(average);

        if (Math.abs(average - 77.733333) < 0.000001) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
}
