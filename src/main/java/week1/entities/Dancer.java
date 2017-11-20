package week1.entities;

public class Dancer extends Performer {

	private String style;

	public Dancer(String style) {
		super();
		this.style = style;
	}

	@Override
	public String getPerformance() {
		return new StringBuilder()
				.append(this.style)
				.append(this.DELIMITER)
				.append(this.unionId)
				.append(this.DELIMITER)
				.append("dancer")
				.toString();
	}

}
