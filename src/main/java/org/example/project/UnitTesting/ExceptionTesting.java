package org.example.project.UnitTesting;

public class ExceptionTesting {
    public static void main(String[] args) {
        /**
         * @异常测试
         *
         * @小结
         * 测试异常可以使用assertThrows()，期待捕获到指定类型的异常；
         * 对可能发生的每种类型的异常都必须进行测试。
         *
         */
    }

    // JUnit提供assertThrows()来期望捕获一个指定的异常。第二个参数Executable封装了我们要执行的会产生异常的代码。当我们执行Factorial.fact(-1)时，必定抛出IllegalArgumentException。assertThrows()在捕获到指定异常时表示通过测试，未捕获到异常，或者捕获到的异常类型不对，均表示测试失败。
    public static long fact(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
