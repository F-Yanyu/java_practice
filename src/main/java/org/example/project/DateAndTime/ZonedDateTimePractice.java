package org.example.project.DateAndTime;

import java.time.*;

public class ZonedDateTimePractice {
    public static void main(String[] args) {
        /**
         * @ZoneDDateTime
         * LocalDateTime总是表示本地日期和时间，要表示一个带时区的日期和时间，我们就需要ZonedDateTime。
         * 可以简单地把ZonedDateTime理解成LocalDateTime加ZoneId。ZoneId是java.time引入的新的时区类，注意和旧的java.util.TimeZone区别。
         */
        //要创建一个ZonedDateTime对象，有以下几种方法，一种是通过now()方法返回当前时间：
        ZonedDateTime zbj = ZonedDateTime.now();
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);

        /*
        另一种方式是通过给一个LocalDateTime附加一个ZoneId，就可以变成ZonedDateTime：
         */
        LocalDateTime ldt2 = LocalDateTime.of(2019,9,15,15,16,17);
        ZonedDateTime zbj2 = ldt2.atZone(ZoneId.systemDefault());
        ZonedDateTime zny2 = ldt2.atZone(ZoneId.of("America/New_York"));
        System.out.println(zbj2);
        System.out.println(zny2);


        /**
         * @时区转换
         * 要转换时区，首先我们需要有一个ZonedDateTime对象，然后，通过withZoneSameInstant()将关联时区转换到另一个时区，转换后日期和时间都会相应调整。
         */
        // 下面的代码演示了如何将北京时间转换为纽约时间：
        ZonedDateTime zbj3 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 转换为纽约时间:
        ZonedDateTime zny3 = zbj3.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("=========时区转换============");
        System.out.println(zbj3);
        System.out.println(zny3);

        /*
        要特别注意，时区转换的时候，由于夏令时的存在，不同的日期转换的结果很可能是不同的。
        有了ZonedDateTime，将其转换为本地时间就非常简单：
            ZonedDateTime zdt = ...
            LocalDateTime ldt = zdt.toLocalDateTime();
        转换为LocalDateTime时，直接丢弃了时区信息。
         */

        /**
         * @练习
         * 某航线从北京飞到纽约需要13小时20分钟，请根据北京起飞日期和时间计算到达纽约的当地日期和时间。
         */
        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println("=========练习==========");
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else {
            System.out.println("测试成功");
        }



        /**
         * @小结
         * ZonedDateTime是带时区的日期和时间，可用于时区转换；
         * ZonedDateTime和LocalDateTime可以相互转换。
         */

    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
        LocalDateTime resultDateTime = bj.plusHours(h).plusMinutes(m);
        ZonedDateTime zdt = resultDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime resultZoned = zdt.withZoneSameInstant(ZoneId.of("America/New_York"));
        LocalDateTime result = resultZoned.toLocalDateTime();
        return result;
    }
}
