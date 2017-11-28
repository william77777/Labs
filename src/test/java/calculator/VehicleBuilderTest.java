package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import calculator.builders.VehicleBuilder;
import calculator.entities.Vehicle;
import calculator.entities.Boat.Boat;
import calculator.entities.automobile.Automobile;
import calculator.entities.automobile.Diesal;
import calculator.entities.automobile.Electric;
import calculator.entities.automobile.Standard;
import calculator.entities.enums.AutomobileType;
import calculator.entities.enums.BoatType;

public class VehicleBuilderTest {
	private static VehicleBuilder builder;

	private final static double DIFF = 0.0001;

	private final static long VIN = 101;
	private final static int RANGE = 200;

	private static final int CODE = 50;
	private final static double PRICE = 2000;

	private static final double LUXURY_TAX = 1000;
	private static final String COLOR = "red";
	private static final String MANUFACTURER = "Toyota";
	
	@Before
	public void initBuilder() {
		builder = new VehicleBuilder();
		builder.setVin(VIN).setRange(RANGE).setPrice(PRICE).setCode(CODE).setLuxuryTax(LUXURY_TAX);
	}

	private void initAutomobile() {
		builder.setColor(COLOR).setManufacturer(MANUFACTURER);
	}

	@Test
	public void test_buildVehicle() {
		Vehicle someVehicle = builder.build(AutomobileType.DIESAL);
		assertTrue(someVehicle instanceof Diesal);
		assertEquals(VIN, someVehicle.getVin());
		assertEquals(RANGE, someVehicle.getRange());
		assertEquals(CODE, someVehicle.getCode());
		assertEquals(PRICE, someVehicle.getPrice(), DIFF);
		assertEquals(LUXURY_TAX, someVehicle.getLuxuryTax(), DIFF);
	}
	
	@Test
	public void test_buildVehicle2() {
		Vehicle someVehicle = builder.setType(AutomobileType.DIESAL).build();
		assertTrue(someVehicle instanceof Diesal);
		assertEquals(VIN, someVehicle.getVin());
		assertEquals(RANGE, someVehicle.getRange());
		assertEquals(CODE, someVehicle.getCode());
		assertEquals(PRICE, someVehicle.getPrice(), DIFF);
		assertEquals(LUXURY_TAX, someVehicle.getLuxuryTax(), DIFF);
	}

	@Test
	public void test_buildBoat() {
		Boat someBoat = (Boat) builder.setBoatType(BoatType.CARGO).build(BoatType.CARGO);
		assertTrue(someBoat instanceof Boat);
		assertEquals(BoatType.CARGO, someBoat.getBoatType());
	}

	@Test
	public void test_buildAutomobile() {
		Automobile someCar = (Automobile) builder.setColor(COLOR).setManufacturer(MANUFACTURER)
				.build(AutomobileType.DIESAL);
		assertTrue(someCar instanceof Automobile);
		assertEquals(COLOR, someCar.getColor());
		assertEquals(MANUFACTURER, someCar.getManufacturer());
	}


	@Test
	public void test_buildDiesal() {
		final int wheels = 4, cylinders = 3;
		initAutomobile();
		Diesal diesalCar = (Diesal) builder.setWheels(wheels).setCylinders(cylinders).build(AutomobileType.DIESAL);
		assertTrue(diesalCar instanceof Diesal);
		assertEquals(wheels, diesalCar.getWheels());
		assertEquals(cylinders, diesalCar.getCylinders());
		assertEquals(false, diesalCar.isLimitable());
		assertEquals(false, diesalCar.isRenewable());
	}

	@Test
	public void test_buildSemiTruck() {
		initAutomobile();
		Diesal diesalCar = (Diesal) builder.build(AutomobileType.SEMIDIESAL);
		assertTrue(diesalCar instanceof Diesal);
		assertEquals(true, diesalCar.isLimitable());
		assertEquals(false, diesalCar.isRenewable());
	}

	@Test
	public void test_buildElectric() {
		final int batteries = 2;
		final boolean tesla = false;
		initAutomobile();
		Electric electricCar = (Electric) builder.setBatteries(batteries).setTesla(tesla)
				.build(AutomobileType.ELECTRIC);
		assertTrue(electricCar instanceof Electric);
		assertEquals(batteries, electricCar.getBatteries());
		assertEquals(tesla, electricCar.isTesla());
		assertEquals(true, electricCar.isLimitable());
		assertEquals(true, electricCar.isRenewable());
	}

	@Test
	public void test_buildStandard() {
		final int seats = 4;
		final LocalDate date = LocalDate.now();
		initAutomobile();
		Standard car = (Standard) builder.setSeats(seats).setDate(date).build(AutomobileType.STANDARD);
		assertTrue(car instanceof Standard);
		assertEquals(seats, car.getSeats());
		assertEquals(date, car.getDate());
		assertEquals(false, car.isLimitable());
		assertEquals(false, car.isRenewable());
	}

	@Test(expected=IllegalArgumentException.class)
	public void test_illegalArgumentException_caughtUnder() {
		builder.setRange(-1).build(AutomobileType.ELECTRIC);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_illegalArgumentException_caughtOver() {
		builder.setRange(500).build(AutomobileType.ELECTRIC);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_nullPointerException_caught() {
		new VehicleBuilder().build();
	}
	
	@Test
	public void  test_outOfVehicleRangeException_notThrownForBoat() {
		builder.setRange(500).build(BoatType.BARGE);
	}
}
