package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {
    private DateTimeService dateTimeService;
    private TravelCalculatePremiumServiceImpl service;
    private TravelCalculatePremiumRequest request;

    @BeforeEach
    void setUp() {
        request = createRequest();
        dateTimeService = Mockito.mock(DateTimeService.class);
        Mockito.when(dateTimeService.calculateDurationInDays(request.getAgreementDateFrom(), request.getAgreementDateTo())).thenReturn(0L);
        service = new TravelCalculatePremiumServiceImpl(dateTimeService);
    }
    @Test
    void shouldPopulateResponseWithCorrectPersonFirstName() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    void shouldPopulateResponseWithCorrectPersonLastName() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    void shouldPopulateResponseWithCorrectDateFrom() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    void shouldPopulateResponseWithCorrectDateTo() {
        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    private TravelCalculatePremiumRequest createRequest() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Bob");
        request.setPersonLastName("White");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());
        return request;
    }
}