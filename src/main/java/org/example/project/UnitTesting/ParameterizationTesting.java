package org.example.project.UnitTesting;

public class ParameterizationTesting {
    public static void main(String[] args) {
        /**
         * @参数化测试
         * 参数化测试和普通测试稍微不同的地方在于，一个测试方法需要接收至少一个参数，然后，传入一组参数反复运行。
         * JUnit提供了一个@ParameterizedTest注解，用来进行参数化测试。
         *
         * @小结
         * 使用参数化测试，可以提供一组测试数据，对一个测试方法反复测试。
         * 参数既可以在测试代码中写死，也可以通过@CsvFileSource放到外部的CSV文件中。
         */


    }

    public static int PersonOfParameterizationTesting(int a){
        System.out.println(Math.abs(a));
        return Math.abs(a);
    }

    public static String capitalize(String s){
        if(s.length() == 0){
            return s;
        }
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }
}
