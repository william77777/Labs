package calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import calculator.builders.BaseVehicleBuilder;
import calculator.entities.Vehicle;
import calculator.entities.automobile.Diesal;
import calculator.entities.automobile.Standard;
import calculator.entities.enums.AutomobileType;
import calculator.entities.enums.BoatType;
import calculator.mock.DiscountCalculator;
import calculator.mock.DiscountDayz;

public class FareCalculatorTest {

	// Test values
	private static final double DIFF = 0.01;
	private static final long VIN = 2121l;
	private static final int RANGE = 299;
	private static final double DISCOUNT = BigDecimal.valueOf(0.14).doubleValue();

	private FareCalculator calculator;

	@Mock
	DiscountCalculator discountCalculator;

	@Mock
	DiscountDayz discountDay, notDiscountDay;

	@Before
	public void init() {
		calculator = new FareCalculator();
		// set up mocks
		MockitoAnnotations.initMocks(this);
	}

	private void initDiscount(boolean isDiscountDay) {
		if (isDiscountDay)
			Mockito.when(discountCalculator.calculateDiscount(Mockito.any())).thenReturn(DISCOUNT);
		else
			Mockito.when(discountCalculator.calculateDiscount(Mockito.any())).thenReturn(0.0);
	}

	private void setUpBaseVehicles() {
		for (Vehicle v : Arrays.asList(
				BaseVehicleBuilder.builderFor(AutomobileType.ELECTRIC).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(BoatType.SPEED).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(BoatType.YACHT).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(AutomobileType.SEMIDIESAL).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(AutomobileType.DIESAL).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(AutomobileType.STANDARD).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(AutomobileType.ELECTRIC).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(BoatType.SPEED).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(BoatType.YACHT).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(AutomobileType.SEMIDIESAL).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(AutomobileType.DIESAL).setVin(VIN).setRange(RANGE).build(),
				BaseVehicleBuilder.builderFor(AutomobileType.STANDARD).setVin(VIN).setRange(RANGE).build())) {
			calculator.addVehicle(v);
		}
	}

	@Test
	public void testCalculateGroupCost() {
		setUpBaseVehicles();
		assertEquals(183969.44, calculator.calculateGroupCost(), DIFF);
	}

	@Test
	public void testGroupDisplayInfo() {
		setUpBaseVehicles();
		System.out.println(calculator.displayVehiclesAndTotalCost());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_catchZeroRangeForNonBoatVehicles() {
		calculator.addVehicle(BaseVehicleBuilder.builderFor(AutomobileType.DIESAL).setRange(0).build());
		calculator.calculateGroupCost();
	}

	@Test
	public void test_zeroBoatRangeStillIncreasesPrice() {
		double prev = calculator.calculateGroupCost();
		calculator.addVehicle(BaseVehicleBuilder.builderFor(BoatType.SPEED).setRange(0).setVin(VIN).build());
		assertTrue(calculator.calculateGroupCost() > prev);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_catchInvalidDiscount_under() {
		calculator.calculateGroupCost(-0.0001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_catchInvalidDiscount_over() {
		calculator.calculateGroupCost(1.00001);
	}

	@Test
	public void test_eletric_withoutDiscount() {
		initDiscount(false);
		Vehicle v = BaseVehicleBuilder.builderFor(AutomobileType.ELECTRIC).setTesla(true).setVin(508).setRange(300)
				.setColor("red").build();
		calculator.addVehicle(v);
		assertEquals(487.21, calculator.calculateGroupCost(discountCalculator.calculateDiscount(notDiscountDay)), DIFF);
		assertEquals(
				"Electric by Tesla with VIN 508 is available to rent in red. This monster has a range of 300 and only costs $487.21 unless range exceeded",
				v.getDisplayInfo());
	}

	/**
	 * TODO
	 */
	@Test
	public void test_boat_withDiscount() {
		initDiscount(true);
		Vehicle v = BaseVehicleBuilder.builderFor(BoatType.YACHT).setVin(90210).setRange(6800).build();
		calculator.addVehicle(v);
		assertEquals(52996.52, calculator.calculateGroupCost(discountCalculator.calculateDiscount(discountDay)), DIFF);
		assertEquals(
				"Yacht with VIN 90210 is available to rent. This beauty has a range of 6,800 and only costs $52,996.52",
				v.getDisplayInfo());
	}


	@Test
	public void test_standard_withoutDiscount() {
		initDiscount(false);
		Vehicle v = BaseVehicleBuilder.builderFor(AutomobileType.STANDARD).setManufacturer("toyota").setColor("blue")
				.setVin(75082).setRange(9800).build();
		calculator.addVehicle(v);
		assertEquals(1915.36, calculator.calculateGroupCost(discountCalculator.calculateDiscount(notDiscountDay)),
				DIFF);
		assertEquals(
				"Standard by toyota with VIN 75082 is available to rent in blue. This beast has a range of 9,800 and only costs $1,915.36",
				v.getDisplayInfo());
	}
	
	@Test
	public void test_semi_withDiscount() {
		initDiscount(true);
		Diesal v = (Diesal) BaseVehicleBuilder.builderFor(AutomobileType.SEMIDIESAL).setManufacturer("Volvo").setVin(7331)
				.setRange(498).build();
		calculator.addVehicle(v);
		assertEquals(6416.35, calculator.calculateGroupCost(discountCalculator.calculateDiscount(discountDay)),
				DIFF);
		assertEquals(
				"SemiTruck by Volvo with VIN 7331 is available to rent in black. This monster has a range of 498 and only costs $6,416.35 unless range exceeded",
				v.getDisplayInfo(discountCalculator.calculateDiscount(discountDay)));
	}
	
	@Test
	public void test_diesel_withDiscount() {
		initDiscount(true);
		Diesal v = (Diesal) BaseVehicleBuilder.builderFor(AutomobileType.DIESAL).setManufacturer("Hummer").setVin(764528).setColor("sunburst orange")
				.setRange(100).build();
		calculator.addVehicle(v);
		assertEquals(974108.30, calculator.calculateGroupCost(discountCalculator.calculateDiscount(discountDay)),
				DIFF);
		assertEquals(
				"Diesel by Hummer with VIN 764528 is available to rent in sunburst orange. This beast has a range of 100 and only costs $974,108.30",
				v.getDisplayInfo(discountCalculator.calculateDiscount(discountDay)));
	}

	@Test
	public void test_standard_withDiscount() {
		initDiscount(true);
		Standard v = (Standard) BaseVehicleBuilder.builderFor(AutomobileType.STANDARD).setManufacturer("toyota")
				.setColor("blue").setVin(75082).setRange(9800).build();
		calculator.addVehicle(v);
		assertEquals(1647.20, calculator.calculateGroupCost(discountCalculator.calculateDiscount(notDiscountDay)),
				DIFF);
		assertEquals(
				"Standard by toyota with VIN 75082 is available to rent in blue. This beast has a range of 9,800 and only costs $1,647.21",
				v.getDisplayInfo(DISCOUNT));
	}
	
	
}
