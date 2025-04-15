package com.solvians.showcase;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class CertificateUpdate {

    // TODO: implement me.
	
	private long timestamp;
	private String ISIN;
	private double bidPrice;
	private int bidSize;
    private double askPrice;
    private int askSize;
    private LocalDate maturityDate;
	
    
    public CertificateUpdate() {
    	    	
    	this.timestamp = System.currentTimeMillis();
        this.ISIN = ISINGenerator.generateISIN();
        this.bidPrice = round(ThreadLocalRandom.current().nextDouble(100.00, 200.00), 2);
        this.bidSize = ThreadLocalRandom.current().nextInt(1000, 5001);
        this.askPrice = round(ThreadLocalRandom.current().nextDouble(100.00, 200.00), 2);
        this.askSize = ThreadLocalRandom.current().nextInt(1000, 10001);
        this.maturityDate = LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(1, 1826)); 

	}


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


	public String getISIN() {
		return ISIN;
	}


	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}


	public double getBidPrice() {
		return bidPrice;
	}


	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}


	public int getBidSize() {
		return bidSize;
	}


	public void setBidSize(int bidSize) {
		this.bidSize = bidSize;
	}


	public double getAskPrice() {
		return askPrice;
	}


	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}


	public int getAskSize() {
		return askSize;
	}


	public void setAskSize(int askSize) {
		this.askSize = askSize;
	}


	public LocalDate getMaturityDate() {
		return maturityDate;
	}


	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}


    private double round(double value, int places) {
        return Math.round(value * Math.pow(10, places)) / Math.pow(10, places);
    }
    
	@Override
	public String toString() {
		return "CertificateUpdate [timestamp=" + timestamp + ", ISIN=" + ISIN + ", bidPrice=" + bidPrice + ", bidSize="
				+ bidSize + ", askPrice=" + askPrice + ", askSize=" + askSize + ", maturityDate=" + maturityDate + "]";
	}
    
    
}
