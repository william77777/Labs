package week1.entities;

public class Vocalist extends Performer {

	private char key;

	public Vocalist(long id, char key) {
		super(id);
		if (!Character.isLetter(key))
			throw new IllegalArgumentException("Key must be a letter");
		this.key = key;
	}

	@Override
	public String getPerformance() {
		return super.buildString("I sing in the key of", this.key, super.getUnionId());
	}

	/**
	 * 
	 * @param volume
	 * @return
	 * @throws VolumeOutOfRangeException
	 */
	public String getPerformance(int volume) {
		if (volume < 0 || volume > 10)
			throw new IllegalArgumentException("Volume needs to be between 0 and 10");
		return super.buildString("I sing in the key of", this.key, "at the volume " + volume, super.getUnionId());
	}

}
