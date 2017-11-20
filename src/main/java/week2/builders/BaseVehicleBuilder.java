package week2.builders;

import java.util.HashMap;
import java.util.Map;

import week2.entities.enums.AutomobileType;
import week2.entities.enums.BoatType;
import week2.entities.enums.VehicleType;

/**
 * Pool for creating and managing vehicle stock Pool contains one vehicle of
 * Each type Each vehicle has default values specified
 * Purpose: to decouple business requirements from implementation of {@link VehicleBuilder}
 * Can be replaced with any other method of initialization
 * @author wums
 *
 */
public class BaseVehicleBuilder{
	private static Map<VehicleType, VehicleBuilder> baseBuilders;

	/**
	 * Initialize pool
	 */
	static {
		// pool
		baseBuilders = new HashMap<>();
		
		// automobiles
		baseBuilders.put(AutomobileType.STANDARD, new VehicleBuilder(AutomobileType.STANDARD).setPrice(3000.0).setCode(12).setLuxuryTax(0.0));
		baseBuilders.put(AutomobileType.ELECTRIC, new VehicleBuilder(AutomobileType.ELECTRIC).setPrice(15000.0).setCode(76).setLuxuryTax(153.0));
		baseBuilders.put(AutomobileType.DIESAL, new VehicleBuilder(AutomobileType.DIESAL).setPrice(8000.0).setCode(54).setLuxuryTax(50.0));
		baseBuilders.put(AutomobileType.SEMIDIESAL, new VehicleBuilder(AutomobileType.SEMIDIESAL).setPrice(20000.0).setCode(66).setLuxuryTax(3000.0));
		
		// boats
		baseBuilders.put(BoatType.YACHT, new VehicleBuilder(BoatType.YACHT).setPrice(985000.0).setCode(8047).setLuxuryTax(60000.0));
		baseBuilders.put(BoatType.SPEED, new VehicleBuilder(BoatType.SPEED).setPrice(35000.0).setCode(123).setLuxuryTax(2200.0));
		baseBuilders.put(BoatType.BARGE, new VehicleBuilder(BoatType.BARGE).setPrice(500000.0).setCode(893).setLuxuryTax(5000.0));
		baseBuilders.put(BoatType.CARGO, new VehicleBuilder(BoatType.CARGO).setPrice(750000.0).setCode(542).setLuxuryTax(8500.0));
	}
	
	public static VehicleBuilder builderFor(VehicleType type) {
		return baseBuilders.get(type);
	}
	
	public static VehicleBuilder [] getBasebuilders(){
		return (VehicleBuilder[]) baseBuilders.values().toArray();
	}
}
















