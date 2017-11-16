package lab.week1.src.entities;

import lab.week1.src.VolumeOutOfRangeException;

public class Vocalist extends Performer {

	private char key;
	
	public Vocalist(char key) {
		super();
		this.key = key;
	}

	@Override
	public String getPerformance() {
		return new StringBuilder()
				.append("I sing in the key of")
				.append(this.DELIMITER)
				.append(this.key)
				.append(this.DELIMITER)
				.append(this.unionId)
				.toString();
	}
	
	/**
	 * 
	 * @param volume
	 * @return
	 * @throws VolumeOutOfRangeException
	 */
	public String getPerformance(int volume) throws VolumeOutOfRangeException {
		if(volume < 0 || volume > 10)
			throw new VolumeOutOfRangeException("Volume needs to be between 0 and 10");
		return new StringBuilder()
				.append("I sing in the key of")
				.append(this.DELIMITER)
				.append(this.key)
				.append(this.DELIMITER)
				.append("at the volume ")
				.append(volume)
				.append(this.DELIMITER)
				.append(this.unionId)
				.toString();
	}
	
}
