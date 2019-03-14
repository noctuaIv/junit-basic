package ua.voytovych.tests;
import static org.junit.Assert.assertTrue;

import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import ua.voytovych.junit.TrackingService;

@RunWith(Theories.class)
public class TrackingServiceTheories {
	@DataPoints
	public static int[] data(){
		return new int[]{
				1, 5, 10, 15, 20, 50, -4
		};
	}
	
	@Theory
	public void positiveValuesShouldAlwaysHavePositiveTotals(int value) {
		TrackingService servise = new TrackingService();
		servise.addProtein(value);
		
		Assume.assumeTrue(value > 0);
		
		assertTrue(servise.getTotal() > 0);
	}
}
