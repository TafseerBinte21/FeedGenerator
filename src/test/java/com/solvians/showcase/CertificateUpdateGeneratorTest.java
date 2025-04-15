package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CertificateUpdateGeneratorTest {

    @Test
    public void generateQuotes() {
        CertificateUpdateGenerator certificateUpdateGenerator = new CertificateUpdateGenerator(10, 100);
        Stream<CertificateUpdate> quotes = certificateUpdateGenerator.generateQuotes();
        assertNotNull(quotes);
        assertEquals(10 * 100, quotes.count());

    }
    
    
    @Test
    public void validateGeneratedCertificateUpdateContent() {
        CertificateUpdateGenerator generator = new CertificateUpdateGenerator(5, 10); // total 50
        Stream<CertificateUpdate> quotes = generator.generateQuotes();

        quotes.forEach(update -> {
            assertNotNull(update.getISIN(), "ISIN should not be null");
            assertEquals(12, update.getISIN().length(), "ISIN should be 12 characters long");

            // Assuming bid/ask prices are in a realistic range
            assert(update.getBidPrice() >= 100 && update.getBidPrice() <= 200);
            assert(update.getAskPrice() >= 100 && update.getAskPrice() <= 200);

            // Sizes should be non-negative
            assert(update.getBidSize() >= 0);
            assert(update.getAskSize() >= 0);

            // Maturity date should be in the future
            assert(update.getMaturityDate().isAfter(java.time.LocalDate.now()));
        });
    }

}