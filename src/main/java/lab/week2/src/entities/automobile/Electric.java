package lab.week2.src.entities.automobile;

public class Electric extends Automobile {

	private int batteries;
	private boolean isTesla;

	public Electric(String vin, int range, double price, int code, double luxuryTax, String color, String manufacturer,
			boolean isLimitable, boolean isRenewable, int batteries, boolean isTesla) {
		super(vin, range, price, code, luxuryTax, color, manufacturer, isLimitable, isRenewable);
		this.batteries = batteries;
		this.isTesla = isTesla;
	}

	public int getBatteries() {
		return batteries;
	}

	public void setBatteries(int batteries) {
		this.batteries = batteries;
	}

	public boolean isTesla() {
		return isTesla;
	}

	public void setTesla(boolean isTesla) {
		this.isTesla = isTesla;
	}

}
