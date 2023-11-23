package org.example.project.ExceptionHanding;

public class UsingLog4j {
    public static void main(String[] args) {
        /**
         * @使用Log4j
         * 当我们使用Log4j输出一条日志时，Log4j自动通过不同的Appender把同一条日志输出到不同的目的地。例如：
         * - console：输出到屏幕；
         * - file：输出到文件；
         * - socket：通过网络输出到远程计算机；
         * - jdbc：输出到数据库
         *
         * 我们在实际使用的时候，并不需要关心Log4j的API，而是通过配置文件来配置它。
         * 把一个log4j2.xml的文件放到classpath下就可以让Log4j读取配置文件并按照我们的配置来输出日志。
         * 一旦日志文件达到指定大小（1MB），Log4j就会自动切割新的日志文件，并最多保留10份。
         *
         * @最佳实践
         * 在开发阶段，始终使用Commons Logging接口来写入日志，并且开发阶段无需引入Log4j。如果需要把日志写入文件，
         * 只需要把正确的配置文件和Log4j相关的jar包放入classpath，就可以自动把日志切换成使用Log4j写入，无需修改任何代码。
         *
         * @小结
         * 通过Commons Logging实现日志，不需要修改代码即可使用Log4j；
         * 使用Log4j只需要把log4j2.xml和相关jar放入classpath；
         * 如果要更换Log4j，只需要移除log4j2.xml和相关jar；
         * 只有扩展Log4j时，才需要引用Log4j的接口（例如，将日志加密写入数据库的功能，需要自己开发）。
         */
    }
}
