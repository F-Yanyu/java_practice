package org.example.project.ExceptionHanding;

// logging
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.UnsupportedEncodingException;

public class UsingJDKLogging {
    public static void main(String[] args) {
        /**
         * @使用JDKLogging 使用JDK日志
         *
         * Java标准库内置了日志包java.util.logging，我们可以直接用。
         * JDK的Logging定义了7个日志级别，从严重到普通：
         * SEVERE
         * WARNING
         * INFO
         * CONFIG
         * FINE
         * FINER
         * FINEST
         */

        Logger logger = Logger.getGlobal();
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored."); // 因为默认级别是INFO，因此，INFO级别以下的日志，不会被打印出来。
        logger.severe("process will be terminated...");


        /**
         * 练习：使用logger.severe()打印异常：
         */
        Logger logger2 = Logger.getLogger(UsingJDKLogging.class.getName());
        logger2.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            // TODO: 使用logger.severe()打印异常
            logger2.severe("at UsingJDKLogging.logger2.severe() throw Exception;");
        }
        logger2.info("Process end.");

    }
}
