package week1.entities;

import static org.junit.Assert.assertEquals;

public class DancerTest extends PerformerTest{

	@Override
	public void test_getPerformance() {
		Dancer d = new Dancer(772, "tap");
		assertEquals("tap - 772 - dancer", d.getPerformance());
	}
	
}
