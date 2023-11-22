package org.example.project.ExceptionHanding;

public class CustomException {
    public static void main(String[] args) {
        /**
         * @自定义异常
         * - 在一个大型项目中，可以自定义新的异常类型，但是，保持一个合理的异常继承体系是非常重要的。
         * - 一个常见的做法是自定义一个BaseException作为“根异常”，然后，派生出各种业务类型的异常。
         * - BaseException需要从一个适合的Exception派生，通常建议从RuntimeException派生：
         * - 其他业务类型的异常就可以从BaseException派生：
         * - 自定义的BaseException应该提供多个构造方法：
         */
        add(2);

        /**
         * @小结
         * 抛出异常时，尽量复用JDK已定义的异常类型；
         * 自定义异常体系时，推荐从RuntimeException派生“根异常”，再派生出业务异常；
         * 自定义异常时，应该提供多种构造方法。
         */

        /**
         * @java标准库常用的异常包括：
         * - Exception
         *   - RuntimeException
         *      - NullPointerException
         *      - IndexOutOfBoundsException
         *      - SecurityException
         *      - IllegalArgumentException
         *          - NumberFormatException
         *   - IOException
         *      - UnsupportedCharsetException
         *      - FileNotFoundException
         *      - SocketException
         *   - ParseException
         *   - GeneralSecurityException
         *   - SQLException
         *   - TimeoutException
         */
    }
    static void add(int a){
        if(a > 10){
            throw new IllegalArgumentException();
        } else if(a < 10){
            throw new BaseException("BaGa");
        }
    }
}

// 自定义
class BaseException extends RuntimeException{
    public BaseException(String message){
        super(message);
    }
}


