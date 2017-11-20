package week1.entities;

import java.util.concurrent.atomic.AtomicLong;

public class Performer {
	private static final AtomicLong generator = new AtomicLong(0l);

	protected final String DELIMITER = " - ";
	protected final long unionId;

	/**
	 * Must call super constructor to initialize id
	 */
	public Performer() {
		this.unionId = generator.getAndIncrement();
	}

	public String getPerformance() {
//		return this.unionId + this.DELIMITER + "performer";
		return buildString(this.unionId,"performer");
	}

	public long getUnionId() {
		return unionId;
	}
	
	/**
	 * Builds a string with the delimiter
	 * @param args
	 * @return
	 */
	protected String buildString(Object...args) {
		StringBuilder s = new StringBuilder("");
		for(Object arg : args) {
			s.append(arg).append(this.DELIMITER);
		}
		return s.toString().substring(0,s.length()-this.DELIMITER.length());
	}

}
