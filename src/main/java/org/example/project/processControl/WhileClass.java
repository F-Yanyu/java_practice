package org.example.project.processControl;

public class whileClass {
    public static void main(String[] args) {
        int i = 1;
        while(i <= 1000000){
            i++;
        }
        System.out.println("i:"+i);


        // 联系：计算m到n的和
        int sum = 0;
        int m = 20;
        int n = 100;
        while(m < 100){
             m++;
             sum += m;
        }

        System.out.println("m到n的和："+sum);
    }
}
