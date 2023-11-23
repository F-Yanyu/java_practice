package org.example.project.ExceptionHanding;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class UsingCommonsLogging {
    static final Log log = LogFactory.getLog(UsingCommonsLogging.class);
    public static void main(String[] args) {
        /**
         * @使用CommonsLogging
         * 第三方日志库，由Apache创建的日志模块。可以作为“日志接口”来使用.
         *  特色：
         *      可以挂接不同的日志系统，并通过配置文件指定挂接的日志系统。
         *      默认情况下，Commons Logging自动搜索并使用Log4j,如果没有找到Log4j,在使用JDK Logging
         */
        Log log = LogFactory.getLog(UsingCommonsLogging.class);
        log.info("start...");
        log.warn("end.");


        /**
         * @在静态方法中引用Log，通常直接定义一个静态类型变量：
         * static final Log log = LogFactory.getLog(Main.class);
         * @在实例方法中引用Log，通常定义一个实例变量：
         * protected final Log log = LogFactory.getLog(getClass());
         * 注意到实例变量log的获取方式是LogFactory.getLog(getClass())，
         * 虽然也可以用LogFactory.getLog(Person.class)，但是前一种方式有个非常大的好处，就是子类可以直接使用该log实例
         */



        /**
         * @练习
         * 使用log.error(String, Throwable)打印异常。
         */
        try{
            int a = Integer.parseInt("haha");
        }catch(Exception e){
            log.error("a must of int",e);
        }
    }
}




