package org.example.project.DateAndTime;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class basicConception {
    public static void main(String[] args) {

        int n = 123400;
        // 123400
        System.out.println(n);
        // 1e208
        System.out.println(Integer.toHexString(n));
        // $123,400.00
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));

        // 获取当前的时间戳
        System.out.println(System.currentTimeMillis());

        /**
         * @Date的基本用法
         *
         */
        // 获取当前时间
        Date date = new Date();
        System.out.println(date.getYear() + 1900);// 必须加上1900
        System.out.println(date.getMonth() + 1); // 必须加上1，0~11
        System.out.println(date.getDate());// 1~31,不能加1
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());

        /**
         * @格式化日期
         * 可以使用SimpleDateFormat对一个Date进行转换。它用预定义的字符串表示格式化：
         *      yyyy：年
         *      MM：月
         *      dd: 日
         *      HH: 小时
         *      mm: 分钟
         *      ss: 秒
         * 我们来看如何以自定义的格式输出：
         */
        // 获取当前时间:
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("格式化后的："+sdf.format(date));

        /*
        Java的格式化预定义了许多不同的格式，我们以MMM和E为例：
        一般来说，字母越长，输出越长。
         */
        var sdf2 = new SimpleDateFormat("E MMM dd, yyyy");
        System.out.println(sdf2.format(date));
        // Date对象有几个严重的问题：它不能转换时区，除了toGMTString()可以按GMT+0:00输出外，Date总是以当前计算机系统的默认时区为基础进行输出。此外，我们也很难对日期和时间进行加减，计算两个日期相差多少天，计算某个月第一个星期一的日期等。


        /**
         * Calendar
         * Calendar可以用于获取并设置年、月、日、时、分、秒，它和Date比，主要多了一个可以做简单的日期和时间运算的功能。
         */
        // 基本用法
        // 获取当前时间:
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = 1 + c.get(Calendar.MONTH);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int w = c.get(Calendar.DAY_OF_WEEK);
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        System.out.println("Calendar基本用法："+y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);
        /*
        注意到Calendar获取年月日这些信息变成了get(int field)，返回的年份不必转换，返回的月份仍然要加1，返回的星期要特别注意，1~7分别表示周日，周一，……，周六。
        Calendar只有一种方式获取，即Calendar.getInstance()，而且一获取到就是当前时间。如果我们想给它设置成特定的一个日期和时间，就必须先清除所有字段：
        利用Calendar.getTime()可以将一个Calendar对象转换成Date对象，然后就可以用SimpleDateFormat进行格式化了。
         */
        // 当前时间:
        Calendar c1 = Calendar.getInstance();
        // 清除所有:
        c1.clear();
        // 设置2019年:
        c1.set(Calendar.YEAR, 2019);
        // 设置9月:注意8表示9月:
        c1.set(Calendar.MONTH, 8);
        // 设置2日:
        c1.set(Calendar.DATE, 2);
        // 设置时间:
        c1.set(Calendar.HOUR_OF_DAY, 21);
        c1.set(Calendar.MINUTE, 22);
        c1.set(Calendar.SECOND, 23);
        System.out.println("Calendar设置时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c1.getTime()));
        // 2019-09-02 21:22:23

        /**
         * @TimeZone
         * Calendar和Date相比，它提供了时区转换的功能。时区用TimeZone对象表示：
         * 时区的唯一标识是以字符串表示的ID，我们获取指定TimeZone对象也是以这个ID为参数获取，GMT+09:00、Asia/Shanghai都是有效的时区ID。要列出系统支持的所有ID，请使用TimeZone.getAvailableIDs()。
         *
         */
        TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
        System.out.println("=============TimeZone时区显示===========");
        System.out.println(tzDefault.getID()); // Asia/Shanghai
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York

        //有了时区，我们就可以对指定时间进行转换。例如，下面的例子演示了如何将北京时间2019-11-20 8:15:00转换为纽约时间：
        // 当前时间:
        Calendar c2 = Calendar.getInstance();
        // 清除所有:
        c2.clear();
        // 设置为北京时区:
        c2.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 设置年月日时分秒:
        c2.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        // 显示时间:
        var sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("========北京时间转换为纽约时间============");
        System.out.println(sdf3.format(c2.getTime()));
        // 2019-11-19 19:15:00

        /*
        可见，利用Calendar进行时区转换的步骤是：
            清除所有字段；
            设定指定时区；
            设定日期和时间；
            创建SimpleDateFormat并设定目标时区；
            格式化获取的Date对象（注意Date对象无时区信息，时区信息存储在SimpleDateFormat中）。
        因此，本质上时区转换只能通过SimpleDateFormat在显示的时候完成。
         */

        // Calendar也可以对日期和时间进行简单的加减：
        // 当前时间:
        Calendar c3 = Calendar.getInstance();
        // 清除所有:
        c3.clear();
        // 设置年月日时分秒:
        c3.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        // 加5天并减去2小时:
        c3.add(Calendar.DAY_OF_MONTH, 5);
        c3.add(Calendar.HOUR_OF_DAY, -2);
        // 显示时间:
        var sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d4 = c3.getTime();
        System.out.println("===========进行简单的加减=============");
        System.out.println(sdf4.format(d4));
        // 2019-11-25 6:15:00


        /**
         * @小结
         * 计算机表示的时间是以整数表示的时间戳存储的，即Epoch Time，Java使用long型来表示以毫秒为单位的时间戳，通过System.currentTimeMillis()获取当前时间戳。
         *
         * Java有两套日期和时间的API：
         *
         * 旧的Date、Calendar和TimeZone；
         * 新的LocalDateTime、ZonedDateTime、ZoneId等。
         * 分别位于java.util和java.time包中。
         */
    }
}
