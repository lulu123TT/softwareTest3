package cn.edu.ctgu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class BillingTest {

    private Billing billing;

    @BeforeEach
    void setUp() {
        ZoneId timeZone = ZoneId.systemDefault();
        billing = new Billing(timeZone);
    }

    @Test
    void testCalculateFee1() {
        LocalDateTime startTime = LocalDateTime.of(2022, 3, 1, 8, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 3, 1, 8, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(0, actualFee, 0.0001);
    }

    @Test
    void testCalculateFee2() {
        LocalDateTime startTime = LocalDateTime.of(2022, 3, 1, 8, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 3, 1, 8, 10, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(0.5, actualFee, 0.0001);
    }

    @Test
    void testCalculateFee3() {
        LocalDateTime startTime = LocalDateTime.of(2022, 3, 1, 8, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 3, 1, 9, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(6, actualFee, 0.0001);
    }

    @Test
    void testCalculateFee4() {
        LocalDateTime startTime = LocalDateTime.of(2022, 3, 27, 8, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 3, 27, 8, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(0, actualFee, 0.0001);
    }

    @Test
    void testCalculateFee5() {
        LocalDateTime startTime = LocalDateTime.of(2022, 3, 27, 8, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 3, 27, 8, 10, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(0.5, actualFee, 0.0001);
    }

    @Test
    void testCalculateFee6() {
        LocalDateTime startTime = LocalDateTime.of(2022, 3, 27, 8, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 3, 27, 9, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(6, actualFee, 0.0001);
    }

    @Test
    void testCalculateFeeDuringDST1() {
        ZoneId timeZone = ZoneId.of("America/New_York");
        Billing billing = new Billing(timeZone);

        LocalDateTime startTime = LocalDateTime.of(2022, 6, 1, 8, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 6, 1, 9, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(6, actualFee, 0.0001);
    }

    @Test
    void testCalculateFeeDuringDST2() {
        ZoneId timeZone = ZoneId.of("America/New_York");
        Billing billing = new Billing(timeZone);

        LocalDateTime startTime = LocalDateTime.of(2022, 6, 1, 9, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 6, 1, 10, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(6, actualFee, 0.0001);
    }


    @Test
    void testCalculateFeeDuringDST3() {
        ZoneId timeZone = ZoneId.of("America/New_York");
        Billing billing = new Billing(timeZone);

        LocalDateTime startTime = LocalDateTime.of(2022, 3, 13, 1, 30, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 3, 13, 3, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(3, actualFee, 0.0001);
    }

    @Test
    void testCalculateFeeDuringDST4() {
        ZoneId timeZone = ZoneId.of("America/New_York");
        Billing billing = new Billing(timeZone);

        LocalDateTime startTime = LocalDateTime.of(2022, 11, 6, 0, 30, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 11, 6, 2, 0, 0);
        double actualFee = billing.calculateFee(startTime, endTime);
        Assertions.assertEquals(9, actualFee, 0.0001);
    }

}
