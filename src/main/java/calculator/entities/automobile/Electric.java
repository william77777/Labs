package calculator.entities.automobile;

public class Electric extends Automobile {

	private final int batteries;
	private final boolean isTesla;

	public Electric(long vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable, int batteries, boolean isTesla) {
		super(vin, range, price, code, luxuryTax, color, manufacturer, isLimitable, isRenewable);
		this.batteries = batteries;
		this.isTesla = isTesla;
	}

	public final int getBatteries() {
		return batteries;
	}

	public final boolean isTesla() {
		return isTesla;
	}

}
