package org.example.project.UnitTesting;

public class ConditionTesting {
    public static void main(String[] args) {
        /**
         * @条件测试
         */

        // 在运行测试的时候，有些时候，我们需要排出某些@Test方法，不要让它运行，这时，我们就可以给它标记一个@Disabled：
        // 类似@Disabled这种注解就称为条件测试，JUnit根据不同的条件注解，决定是否运行当前的@Test方法。

        /*
        条件测试：
            @EnabledOnOs(OS.WINDOWS)：只能在Windows上跑
            @DisabledOnOs(OS.WINDOWS)：不在Windows平台执行的测试
            @DisabledOnJre(JRE.JAVA_8)：只能在Java 9或更高版本执行的测试
            @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*"):只能在64位操作系统上执行的测试
            @EnabledIfEnvironmentVariable(named = "DEBUG", matches = "true"):需要传入环境变量DEBUG=true才能执行的测试

         */


    }
    public static int personOfConditionTest(boolean n){
        int a;
        if(n == true){
            System.out.println(Math.random()+1);
            a = 100;
        } else {
            a = 200;
        }
        return a;
    }
}
