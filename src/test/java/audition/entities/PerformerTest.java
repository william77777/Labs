package audition.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import audition.entities.Performer;

public class PerformerTest {
	@Test
	public void test_getPerformance() {
		Performer p = new Performer(324);
		assertEquals("324 - performer", p.getPerformance());
	}
}
