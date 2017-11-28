package audition.entities;

public class Performer {
	private static final String DELIMITER = " - ";
	private final long unionId;

	/**
	 * Call with IdGen.generateId()
	 * @param unionId
	 */
	public Performer(long unionId) {
		super();
		this.unionId = unionId;
	}

	public String getPerformance() {
		return this.buildString(this.unionId, "performer");
	}

	public long getUnionId() {
		return unionId;
	}

	/**
	 * Builds a string with the delimiter
	 * 
	 * @param args
	 * @return
	 */
	public String buildString(Object... args) {
		StringBuilder s = new StringBuilder("");
		for (Object arg : args) {
			s.append(arg).append(Performer.DELIMITER);
		}
		return s.toString().substring(0, s.length() - Performer.DELIMITER.length());
	}

}
