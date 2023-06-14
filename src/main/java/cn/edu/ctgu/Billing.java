package cn.edu.ctgu;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
public class Billing {

    private final ZoneId timeZone;

    public Billing(final ZoneId timeZone) {
        this.timeZone = timeZone;
    }

    public double calculateFee(final LocalDateTime startTime, final LocalDateTime endTime) {
        long timeLength = calculateTimeSpan(startTime, endTime);
        double fee = 0;
        final int num = 20;
        final double fee1 = 0.05;
        final double fee2 = 0.1;

        if (timeLength <= 0) {
            return fee;
        } else if (timeLength <= num) {
            fee = timeLength * fee1;
        } else {
            fee = (timeLength - num) * fee2 + 2;
        }

        return fee;
    }

    public long calculateTimeSpan(final LocalDateTime startTime, final LocalDateTime endTime) {
        //计算时间差
        //当在夏令时时，时间差会多1小时，需要减去1小时
        final int num = 60;
        ZonedDateTime start = ZonedDateTime.of(startTime, timeZone);
        ZonedDateTime end = ZonedDateTime.of(endTime, timeZone);
        Duration duration = Duration.between(start, end);
        long timeLength = duration.toMinutes();
        if (isDuringDST(start) && !isDuringDST(end)) {
            timeLength -= num;
        }
        //当夏令时结束时，时间差会少1小时，需要加上1小时
        if (!isDuringDST(start) && isDuringDST(end)) {
            timeLength += num;
        }
        return timeLength;
    }

    private boolean isDuringDST(final ZonedDateTime dateTime) {
        final int month1 = 3;
        final int month2 = 11;
        TemporalAdjuster secondSunday = TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY);
        LocalDateTime start = LocalDateTime.of(dateTime.getYear(), month1, 1, 2, 0, 0).with(secondSunday);
        TemporalAdjuster firstSunday = TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY);
        LocalDateTime end = LocalDateTime.of(dateTime.getYear(), month2, 1, 2, 0, 0).with(firstSunday);

        return dateTime.isAfter(
                ZonedDateTime.of(start, timeZone)) && dateTime.isBefore(ZonedDateTime.of(end, timeZone));

    }

}
