package org.example.project.basics;

public class VariablesAndDataTypes {
    public static void main(String[] args) {
        /**
         * variablesAndDataTypes
         * Types is
         *      byte short int long
         *      float double
         *      boolean
         *      char
         */
        int x = 100; // 定义int类型变量x，并赋予初始值100
        System.out.println(x); // 打印该变量的值

        x += 100;

        long y = 9000000000000000000L;
        y += x;
        System.out.println(x);
        System.out.println(y);

//        float
        float f = 3.14f;

//        doubel
        double d = 3.14;
        System.out.println(f + d);

//        var
        StringBuilder sb = new StringBuilder();
//        var rb = new StringBuilder(); // java 10以后的版本才有

        //        类型提升
        int n = 5;
        double z = 1.2 + 24.0 / n; // 6.0
        System.out.println(z);

//        整数运算在除数为0时会报错，而浮点数运算在除数为0时，不会报错，但会返回几个特殊值：
        double d1 = 0.0 / 0; // NaN
        double d2 = 1.0 / 0; // Infinity
        double d3 = -1.0 / 0; // -Infinity
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);

//    强制转换
//    可以将浮点数强制转型为整数。在转型时，浮点数的小数部分会被丢掉。如果转型后超过了整型能表示的最大范围，将返回整型的最大值。例如：
        int n1 = (int) 12.3; // 12
        int n2 = (int) 12.7; // 12
        int n3 = (int) -12.7; // -12
        int n4 = (int) (12.7 + 0.5); // 13
        int n5 = (int) 1.2e20; // 2147483647
    }
}
