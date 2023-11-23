package org.example.project.ExceptionHanding;

public class UsingSLF4JAndLogback {
    public static void main(String[] args) {
        /**
         * @SLF4J和Logback
         * 其实SLF4J类似于Commons Logging，也是一个日志接口，而Logback类似于Log4j，是一个日志的实现。
         *
         * 其功能跟commonsLogging和Log4j类似，只是相对接口实现上要方便与先者
         * 目前的趋势，越来越多的开源项目从Commons Logging+Log4j转向了SLF4J和Logback.
         *
         * @小结
         * SLF4J和Logback可以取代Commons Logging和Log4j;
         * 始终使用SLF4J的接口写入日志，使用Logback只需要配置，不需要修改代码。
         */
    }
}
