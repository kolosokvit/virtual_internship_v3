package org.javaguru.travel.insurance.core;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateTimeService {
    public long calculateDurationInDays(Date dateFrom, Date dateTo) {
        return (dateTo.getTime() - dateFrom.getTime()) / (1000 * 60 * 60 * 24);
    }
}
