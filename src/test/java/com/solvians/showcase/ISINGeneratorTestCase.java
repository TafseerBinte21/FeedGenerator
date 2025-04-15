package com.solvians.showcase;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class ISINGeneratorTestCase {
	
	// Length check test
	@Test
    public void lengthCheckTest() {
        ISINGenerator generator = new ISINGenerator();
        String isin = generator.generateISIN();
        assertEquals(12, isin.length(), "ISIN number 12 characters long");
    }
	
	// Check ISIN number starts with first two upercase letters
    @Test
    public void uppercaseCheckTest() {
        ISINGenerator generator = new ISINGenerator();
        String isin = generator.generateISIN();
        assertTrue(isin.substring(0, 2).matches("[A-Z]{2}"), "ISIN starts with two uppercase letters");
    }

    // Check ISIN number has 9 alphanumeric 
    @Test
    public void alphanumericCheckTest() {
        ISINGenerator generator = new ISINGenerator();
        String isin = generator.generateISIN();
        String body = isin.substring(2, 11); // 9 characters after first 2
        assertTrue(body.matches("[A-Z0-9]{9}"), "ISIN has 9 alphanumeric characters");
    }

    // Generate ISIN and print it
    @Test
    void testGenerateISIN() {
        ISINGenerator generator = new ISINGenerator();

        String isin = generator.generateISIN();
        System.out.println("Generated ISIN: " + isin);

       
    }

}
