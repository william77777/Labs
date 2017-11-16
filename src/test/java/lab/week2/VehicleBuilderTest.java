package lab.week2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import lab.week2.builders.VehicleBuilder;
import lab.week2.entities.Vehicle;
import lab.week2.entities.Boat.Boat;
import lab.week2.entities.automobile.Automobile;
import lab.week2.entities.automobile.Diesal;
import lab.week2.entities.automobile.Electric;
import lab.week2.entities.automobile.Standard;
import lab.week2.entities.enums.AutomobileType;
import lab.week2.entities.enums.BoatType;

public class VehicleBuilderTest {
	private static VehicleBuilder builder;

	private final double episilon = 0.0001;

	private final static long VIN = 101;
	private final static int RANGE = 200;

	private static final int CODE = 50;
	private final static double PRICE = 2000;

	private static final double LUXURY_TAX = 1000;
	private final String COLOR = "red";
	private final String MANUFACTURER = "Toyota";

	@BeforeClass
	public static void initBuilder() {
		builder = new VehicleBuilder();
		builder.setVin(VIN).setRange(RANGE).setPrice(PRICE).setCode(CODE).setLuxuryTax(LUXURY_TAX);
	}

	private void initAutomobile() {
		builder.setColor(COLOR).setManufacturer(MANUFACTURER);
	}

	@Test
	public void test_buildVehicle() {
		Vehicle someVehicle = builder.build(AutomobileType.DIESAL);
		assertEquals(VIN, someVehicle.getVin());
		assertEquals(RANGE, someVehicle.getRange());
		assertEquals(CODE, someVehicle.getCode());
		assertEquals(PRICE, someVehicle.getPrice(), episilon);
		assertEquals(LUXURY_TAX, someVehicle.getLuxuryTax(), episilon);
	}

	@Test
	public void test_buildBoat() {
		Boat someBoat = (Boat) builder.setBoatType(BoatType.CARGO).build(BoatType.CARGO);
		assertEquals(BoatType.CARGO, someBoat.getBoatType());
	}

	@Test
	public void test_buildAutomobile() {
		Automobile someCar = (Automobile) builder.setColor(COLOR).setManufacturer(MANUFACTURER)
				.build(AutomobileType.DIESAL);
		assertEquals(COLOR, someCar.getColor());
		assertEquals(MANUFACTURER, someCar.getManufacturer());
	}


	@Test
	public void test_buildDiesal() {
		final int wheels = 4, cylinders = 3;
		initAutomobile();
		Diesal diesalCar = (Diesal) builder.setWheels(wheels).setCylinders(cylinders).build(AutomobileType.DIESAL);
		assertEquals(wheels, diesalCar.getWheels());
		assertEquals(cylinders, diesalCar.getCylinders());
		assertEquals(false, diesalCar.isLimitable());
		assertEquals(false, diesalCar.isRenewable());
	}

	@Test
	public void test_buildSemiTruck() {
		initAutomobile();
		Diesal diesalCar = (Diesal) builder.build(AutomobileType.SEMIDIESAL);
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
		assertEquals(seats, car.getSeats());
		assertEquals(date, car.getDate());
		assertEquals(false, car.isLimitable());
		assertEquals(false, car.isRenewable());
	}

}
