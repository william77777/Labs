package audition;

import org.junit.Before;
import org.junit.Test;

import audition.Audition;
import audition.entities.Dancer;
import audition.entities.Performer;
import audition.entities.Vocalist;

public class AuditionTest {
	private Audition audition;
	@Before
	public void init() {
		audition = new Audition();
		audition.addAudition(new Performer(324));
		audition.addAudition(new Performer(500));
		audition.addAudition(new Vocalist(1191, 'G'));
		audition.addAudition(new Dancer(772, "tap"));
	}
	
	/**
	 * Fails if exception is thrown
	 */
	@Test
	public void test_performAuditions() {
		audition.performAuditions(4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_performAuditions_exceptionThrown() {
		audition.performAuditions(5);
	}
}
