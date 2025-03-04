package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {

    TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl();

    @Test
    void shouldPopulateTravelCalculatePremiumResponse() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Bob");
        request.setPersonLastName("White");
        request.setAgreementDateFrom(new Date());
        request.setAgreementDateTo(new Date());

        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

}