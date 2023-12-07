package org.example.project.UnitTesting;

/**
 * @该方法用于练习单元测试
 */
public class Factorial {
    public static long fact(long n) {
        long r = 1;
        for (long i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }
}
