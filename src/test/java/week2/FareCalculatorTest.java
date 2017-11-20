package week2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import week2.builders.BaseVehicleBuilder;
import week2.entities.enums.AutomobileType;
import week2.entities.enums.BoatType;

public class FareCalculatorTest {

	// Test values
	private static final double DIFF = 0.001;
	private static final long VIN = 2121l;
	private static final int RANGE = 299;

	private static FareCalculator calculator;

	@BeforeClass
	public static void init() {
		calculator = new FareCalculator(Arrays.asList(
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
				BaseVehicleBuilder.builderFor(AutomobileType.STANDARD).setVin(VIN).setRange(RANGE).build()));
	}

	@Test
	public void testCalculateGroupCost() {
		assertEquals(183969.44, calculator.calculateGroupCost(), DIFF);
	}

	@Test
	public void testGroupDisplayInfo() {
		System.out.println(calculator.displayVehiclesAndTotalCost());
	}

}
