package org.javaguru.travel.insurance.core;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DatetimeServiceTest {
    DateTimeService datetimeService = new DateTimeService();
    @Test
    void shouldReturnZeroWhenDatesEquals() {
        Date dateFrom = createDate("01.01.2025");
        Date dateTo = createDate("01.01.2025");
        assertEquals(0, datetimeService.calculateDurationInDays(dateFrom, dateTo));
    }

    @Test
    void shouldReturnPositiveNumberWhenDateToIsBiggerThanDateFrom() {
        Date dateFrom =createDate("01.01.2025");
        Date dateTo = createDate("10.01.2025");
        System.out.println(datetimeService.calculateDurationInDays(dateFrom, dateTo));
        assertTrue(datetimeService.calculateDurationInDays(dateFrom, dateTo) > 0);
    }

    @Test
    void shouldReturnNegativeNumberWhenDateToIsLessThanDateFrom() {
        Date dateFrom = createDate("10.01.2025");
        Date dateTo = createDate("01.01.2025");
        assertTrue(datetimeService.calculateDurationInDays(dateFrom, dateTo) < 0);
    }

    private Date createDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}