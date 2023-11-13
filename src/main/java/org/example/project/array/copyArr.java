package org.example.project.array;

import java.util.Arrays;

public class copyArr {
    public static void main(String[] args){
        //将 int[] arr1 = {10,2,30}; 拷贝到 arr2数组，要求数据空间是独立的

        int[] arr1 = {10,2,30};
        int[] arr2 = new int[arr1.length];

        for(int i = 0;i < arr1.length;i++){
            arr2[i] = arr1[i];
        }
        arr2[1] = 30;

        System.out.println("arr1"+Arrays.toString(arr1));
        System.out.println("arr2"+Arrays.toString(arr2));
    }
}
