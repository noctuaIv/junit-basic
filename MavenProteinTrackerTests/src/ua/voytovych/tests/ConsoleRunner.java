package ua.voytovych.tests;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class ConsoleRunner {
	
	public static void main(String arg[]){
		
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
		
		junit.run(TrackingServiceTests.class);
		
		
	}
}
