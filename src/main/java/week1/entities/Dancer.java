package week1.entities;

public class Dancer extends Performer {

	private final String style;

	public Dancer(String style) {
		super();
		this.style = style;
	}

	public Dancer(long unionId, String style) {
		super(unionId);
		this.style = style;
	}

	@Override
	public String getPerformance() {
		return super.buildString(this.style, super.getUnionId(), "dancer");
	}

}
