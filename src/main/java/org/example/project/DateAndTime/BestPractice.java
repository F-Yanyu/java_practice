package org.example.project.DateAndTime;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class BestPractice {
    public static void main(String[] args) {
        /**
         * @最佳实践
         */

        /**
         * @旧API转新API
         * 如果要把旧式的Date或Calendar转换为新API对象，可以通过toInstant()方法转换为Instant对象，再继续转换为ZonedDateTime：
         */
        // Date -> Instant:
        Instant ins1 = new Date().toInstant();
        System.out.println(ins1);
        // Calendar -> Instant -> ZonedDateTime:
        Calendar calendar = Calendar.getInstance();
        Instant ins2 = calendar.toInstant();
        System.out.println(ins2);
        ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId()); // 从上面的代码还可以看到，旧的TimeZone提供了一个toZoneId()，可以把自己变成新的ZoneId。
        System.out.println(zdt);

        /**
         * @新API转旧API
         * 如果要把新的ZonedDateTime转换为旧的API对象，只能借助long型时间戳做一个“中转”：
         */
        // ZonedDateTime -> long:
        ZonedDateTime zdt2 = ZonedDateTime.now();
        long ts = zdt2.toEpochSecond() * 1000;

        // long -> Date:
        Date date = new Date(ts);

        // long -> Calendar:
        Calendar calendar2 = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone(zdt2.getZone().getId()));
        calendar.setTimeInMillis(zdt2.toEpochSecond() * 1000);
        // 从上面的代码还可以看到，新的ZoneId转换为旧的TimeZone，需要借助ZoneId.getId()返回的String完成。


        /**
         * @在数据库中存储日期和时间
         * 实际上，在数据库中，我们需要存储的最常用的是时刻（Instant），因为有了时刻信息，就可以根据用户自己选择的时区，显示出正确的本地时间。所以，最好的方法是直接用长整数long表示，在数据库中存储为BIGINT类型。
         * 通过存储一个long型时间戳，我们可以编写一个timestampToString()的方法，非常简单地为不同用户以不同的偏好来显示不同的本地时间：
         *
         *
         */

        /**
         * @小结
         * 处理日期和时间时，尽量使用新的java.time包；
         * 在数据库中存储时间戳时，尽量使用long型时间戳，它具有省空间，效率高，不依赖数据库的优点。
         */
    }
}
