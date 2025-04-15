package com.solvians.showcase;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ISINGenerator {
	
	private static final Random random = ThreadLocalRandom.current();
	
	private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public String generateISIN() { 
		
        String firstTwoUppercaseLetter = generateRandomCharacters();  
        String alphanumericCharac = randomAlphanumericCharacters();  
        String base = firstTwoUppercaseLetter + alphanumericCharac;  
        int checkDigit = generateCheckDigit(base);  
        return base + checkDigit;  
    }  
	
	
    private static String generateRandomCharacters() {
    	
    	StringBuilder sb = new StringBuilder();
    	
        for (int i = 0; i < 2; i++) {
        	
        	char firstTwoCharac = alphabet.charAt(random.nextInt(0, alphabet.length()));
        	sb.append(firstTwoCharac);
        	
        }
    	
        return sb.toString();
    }
    
    private static String randomAlphanumericCharacters() {
    	
    	 	String numbers = "0123456789";
    	    String ALPHANUMERIC = numbers + alphabet;
    	    
    	    StringBuilder sb = new StringBuilder();
    	    
    	    for (int i = 0; i < 9; i++) {
    	        char randomChar = ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length()));
    	        sb.append(randomChar);
    	    }
    	    
    	    return sb.toString();
    }
    
    
    
    private static int generateCheckDigit(String base) {
    	
    	 StringBuilder sb = new StringBuilder();
    	 
    	 // Step 1: Convert any letters to numbers by the conversion table
    	    for (char c : base.toCharArray()) {
    	        int converted = charToNumber(c);
    	        sb.append(converted);
    	    }

    	    String numericString = sb.toString();
    	    int sum = 0;
    	    boolean doubleDigit = true;

    	    // Step 2: Start from the rightmost digit, every other digit is multiplied by two
    	    // Add up the resulting string of digits
    	    for (int i = numericString.length() - 1; i >= 0; i--) {
    	        int digit = Character.getNumericValue(numericString.charAt(i));
    	        if (doubleDigit) {
    	            digit *= 2;
    	            if (digit > 9) {
    	                sum += digit / 10 + digit % 10;
    	            } else {
    	                sum += digit;
    	            }
    	        } else {
    	            sum += digit;
    	        }
    	        doubleDigit = !doubleDigit;
    	    }

    	    // Step 4: Find multiple of 10
    	    int checkDigit = (10 - (sum % 10)) % 10;
    	    return checkDigit;
    }
    
    
    // Conversion table for characters
    private static int charToNumber(char c) {
        if (c == 'A') return 10;
        else if (c == 'B') return 11;
        else if (c == 'C') return 12;
        else if (c == 'D') return 13;
        else if (c == 'E') return 14;
        else if (c == 'F') return 15;
        else if (c == 'G') return 16;
        else if (c == 'H') return 17;
        else if (c == 'I') return 18;
        else if (c == 'J') return 19;
        else if (c == 'K') return 20;
        else if (c == 'L') return 21;
        else if (c == 'M') return 22;
        else if (c == 'N') return 23;
        else if (c == 'O') return 24;
        else if (c == 'P') return 25;
        else if (c == 'Q') return 26;
        else if (c == 'R') return 27;
        else if (c == 'S') return 28;
        else if (c == 'T') return 29;
        else if (c == 'U') return 30;
        else if (c == 'V') return 31;
        else if (c == 'W') return 32;
        else if (c == 'X') return 33;
        else if (c == 'Y') return 34;
        else if (c == 'Z') return 35;
        else return Character.getNumericValue(c); 
    }

    }



