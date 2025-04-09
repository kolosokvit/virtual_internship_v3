package org.javaguru.travel.insurance.core;

import java.util.Date;

public class DateTimeService {
    public long calculateDurationInDays(Date dateFrom, Date dateTo) {
        return (dateTo.getTime() - dateFrom.getTime()) / (1000 * 60 * 60 * 24);
    }
}
