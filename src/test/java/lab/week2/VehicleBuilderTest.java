package lab.week2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import lab.week2.builders.VehicleBuilder;
import lab.week2.entities.automobile.Diesal;
import lab.week2.entities.enums.AutomobileType;

public class VehicleBuilderTest {

	VehicleBuilder builder;
	
	private final long VIN=101;
	private final int RANGE=200,CODE=50;
	private final double PRICE=2000,LUXURY_TAX=1000;
	private final String COLOR="red";
	private final String MANUFACTURER="Toyota";
	
	@Before
	public void initBuilder() {
		builder = new VehicleBuilder();
		builder.setVin(VIN)
		.setRange(RANGE)
		.setPrice(PRICE)
		.setCode(CODE)
		.setLuxuryTax(LUXURY_TAX);
	}
	
	private void initAutomobile() {
		builder.setColor(COLOR)
		.setManufacturer(MANUFACTURER);
	}
	
	
	
	@Test
	public void test_buildDiesal() {
		final int wheels = 4, cylinders = 3;
		initAutomobile();
		Diesal diesalCar = (Diesal) builder.setWheels(wheels)
		.setCylinders(cylinders)
		.build(AutomobileType.DIESAL);
		assertEquals(VIN, diesalCar.getVin());
		assertEquals(RANGE, diesalCar.getRange());
		assertEquals(CODE, diesalCar.getCode());
		assertEquals(PRICE, diesalCar.getPrice(),0.0001);
		assertEquals(LUXURY_TAX, diesalCar.getLuxuryTax(),0.0001);
		assertEquals(COLOR, diesalCar.getColor());
		assertEquals(MANUFACTURER, diesalCar.getManufacturer());
	}
	
}
