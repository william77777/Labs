package week1.entities;

import java.util.concurrent.atomic.AtomicLong;

public class Performer {
	private static final AtomicLong generator = new AtomicLong(0l);

	private static final String DELIMITER = " - ";
	private final long unionId;

	/**
	 * Must call super constructor to initialize id
	 */
	public Performer() {
		this.unionId = generator.getAndIncrement();
	}

	/**
	 * Call with IdGen.generateId()
	 * @param unionId
	 */
	public Performer(long unionId) {
		super();
		this.unionId = unionId;
	}

	public String getPerformance() {
		return buildString(this.unionId, "performer");
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
