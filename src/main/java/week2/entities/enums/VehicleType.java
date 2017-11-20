package week2.entities.enums;

public interface VehicleType {
	default public String getParentType() {
		return this.getClass().getSimpleName();
	}
}
