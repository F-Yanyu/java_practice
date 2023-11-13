package org.example.project.array;

public class practiceHenAverage {
    public static void main(String[] args) {
        double[] hens = {20,30,23.3,40};
        double totalHens = 0;
        double average = 0;

        for(int i = 0; i < hens.length; i++){
            totalHens += hens[i];
        }

        average = totalHens / hens.length;
        System.out.println("母鸡平均："+ average);
    }
}
