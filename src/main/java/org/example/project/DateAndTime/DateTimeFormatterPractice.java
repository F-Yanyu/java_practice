package org.example.project.DateAndTime;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterPractice {
    public static void main(String[] args) {
        /**
         * @DateTimeFormatter
         * 使用旧的Date对象时，我们用SimpleDateFormat进行格式化显示。使用新的LocalDateTime或ZonedDateTime时，我们要进行格式化显示，就要使用DateTimeFormatter
         *
         * 和SimpleDateFormat不同的是，DateTimeFormatter不但是不变对象，它还是线程安全的。线程的概念我们会在后面涉及到。现在我们只需要记住：因为SimpleDateFormat不是线程安全的，使用的时候，只能在方法内部创建新的局部变量。而DateTimeFormatter可以只创建一个实例，到处引用。
         */

        // 创建DateTimeFormatter时，我们仍然通过传入格式化字符串实现：
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        // 格式化字符串的使用方式与SimpleDateFormat完全一致。
        //另一种创建DateTimeFormatter的方法是，传入格式化字符串时，同时指定Locale：
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("E,yyyy-MM-dd HH:mm", Locale.US);

        /**
         * @小结
         * 对ZonedDateTime或LocalDateTime进行格式化，需要使用DateTimeFormatter类；
         * DateTimeFormatter可以通过格式化字符串和Locale对日期和时间进行定制输出。
         */

    }
}
