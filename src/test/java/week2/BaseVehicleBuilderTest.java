package week2;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import week2.builders.BaseVehicleBuilder;
import week2.builders.VehicleBuilder;
import week2.entities.Vehicle;
import week2.entities.enums.AutomobileType;
import week2.entities.enums.BoatType;

@RunWith(Parameterized.class)
public class BaseVehicleBuilderTest {

	// Test values
	private static final double DIFF = 0.001;
	private static final long VIN = 2121l;
	private static final int RANGE = 299;

	// Parameters
	private BigDecimal expectedValue;
	private Vehicle baseVehicle;

	public BaseVehicleBuilderTest(BigDecimal expectedValue, Vehicle baseVehicle) {
		this.expectedValue = expectedValue;
		this.baseVehicle = baseVehicle;
	}

	@Parameters
	public static List<Object[]> parameters() {
		List<Object[]> parameters = new LinkedList<>(Arrays.asList(new Object[][] {
				// automobiles
				{ BigDecimal.valueOf(1773.41), BaseVehicleBuilder.builderFor(AutomobileType.STANDARD) },
				{ BigDecimal.valueOf(1553.06), BaseVehicleBuilder.builderFor(AutomobileType.ELECTRIC) },
				{ BigDecimal.valueOf(1100.91), BaseVehicleBuilder.builderFor(AutomobileType.DIESAL) },
				{ BigDecimal.valueOf(5149.59), BaseVehicleBuilder.builderFor(AutomobileType.SEMIDIESAL) },
				// boats
				{ BigDecimal.valueOf(66078.13), BaseVehicleBuilder.builderFor(BoatType.YACHT) },
				{ BigDecimal.valueOf(16329.62), BaseVehicleBuilder.builderFor(BoatType.SPEED) },
				{ BigDecimal.valueOf(32802.64), BaseVehicleBuilder.builderFor(BoatType.BARGE) },
				{ BigDecimal.valueOf(77211.51), BaseVehicleBuilder.builderFor(BoatType.CARGO) } }));

		// set and build
		for (Object[] p : parameters) {
			p[1] = ((VehicleBuilder) p[1]).setVin(VIN).setRange(RANGE).build();
		}
		
		return parameters;
	}

	@Test
	public void testCalculateCost_forBaseVehicles() {
		assertEquals(expectedValue.doubleValue(), baseVehicle.calculateCost(), DIFF);
	}
}
