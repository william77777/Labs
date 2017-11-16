package lab.week2.src.entities;

import lab.week2.src.entities.Boat.Boat;

public abstract class Vehicle {
	private String vin;
	private int range;
	private double price;
	private int code;
	private double luxuryTax;

	public abstract String getDisplayInfo();

	/**
	 * Need to handle a range of zero
	 * @return
	 */
	public double calculateCost() {
		if(this.range == 0) {
			if(this.getClass().equals((Boat.class))) {
				
			}
		}
		return 0.0;
	}

	public Vehicle(String vin, int range, double price, int code, double luxuryTax) {
		super();
		this.vin = vin;
		this.range = range;
		this.price = price;
		this.code = code;
		this.luxuryTax = luxuryTax;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getLuxuryTax() {
		return luxuryTax;
	}

	public void setLuxuryTax(double luxuryTax) {
		this.luxuryTax = luxuryTax;
	}
	
	
}
