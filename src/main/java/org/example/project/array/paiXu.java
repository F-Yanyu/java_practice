package org.example.project.array;

import java.util.Arrays;

public class paiXu {
    public static void main(String[] args) {
        int[] ns = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        // 小大排序前:
        System.out.println(Arrays.toString(ns));
        for(int i = 0; i < ns.length - 1;i++){
            for(int j = 0;j < ns.length - i - 1;j++){
                // 交换ns[j] 大于 ns[j + 1]的位置
                if(ns[j] > ns[j + 1]){
                    int tmp = ns[j];
                    ns[j] = ns[j + 1];
                    ns[j + 1] = tmp;
                }
            }
        }
        // 小大排序后:
        System.out.println(Arrays.toString(ns));


        // 使用java标准库内置排序功能
        int[] testArr = {13,3,444,66,777};
        Arrays.sort(testArr);
        System.out.println(Arrays.toString(testArr));


        // 练习，请思考如何实现对数组进行降序排序：
        for(int i = 0;i < ns.length - 1;i++){
            for(int j = i;j < ns.length;j++){
                if(ns[i] < ns[j]){
                    int tmp = ns[i];
                    ns[i] = ns[j];
                    ns[j] = tmp;
                }
            }
        }

        // 大小排序后:
        System.out.println(Arrays.toString(ns));
        if (Arrays.toString(ns).equals("[96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
            System.out.println("测试成功");
        } else {
            System.out.println("测试失败");
        }
    }
}
