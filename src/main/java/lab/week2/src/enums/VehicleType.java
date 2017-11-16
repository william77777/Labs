package lab.week2.src.enums;

public interface VehicleType {
	default public String getParentType() {
		return this.getClass().getSimpleName();
	}
}
