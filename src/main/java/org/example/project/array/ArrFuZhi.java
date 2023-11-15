package org.example.project.array;

public class ArrFuZhi {
    public static void main(String[] args){
        /**
         * 基本数据类型的赋值是拷贝赋值
         * ------------
         * 数组是引用类型，默认情况下是引用传递，赋的值是地址，赋值方式是引用赋值
         * 下面距离说明
         */

        int[] a = new int[]{10,20,30};
        int[] b = a;
        b[0] = 200;
        for(int i = 0; i < a.length;i++){
            System.out.println(a[i]);
        }
    }
}
