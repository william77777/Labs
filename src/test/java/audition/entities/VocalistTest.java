package audition.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import audition.entities.Vocalist;

public class VocalistTest extends PerformerTest {

	@Override
	public void test_getPerformance() {
		Vocalist v = new Vocalist(1191, 'G');
		assertEquals("I sing in the key of - G - 1191", v.getPerformance());
	}
	
	@Test
	public void test_getPerformance_withVolume() {
		Vocalist v = new Vocalist(1245, 'G');
		assertEquals("I sing in the key of - G - at the volume 7 - 1245", v.getPerformance(7));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_catchKeyNotLetter_producesIllegalArgumentException() {
		@SuppressWarnings("unused")
		Vocalist v = new Vocalist(1245, '1');
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_catchVolumeNotBetweenZeroAndTen_producesIllegalArgumentException() {
		Vocalist v = new Vocalist(1245, 'G');
		v.getPerformance(11);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_catchVolumeNotBetweenZeroAndTen_producesIllegalArgumentException1() {
		Vocalist v = new Vocalist(1245, 'G');
		v.getPerformance(-1);
	}
}
