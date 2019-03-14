package ua.voytovych.tests;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import ua.voytovych.junit.InvalidGoalException;
import ua.voytovych.junit.TrackingService;

public class TrackingServiceTests {
	
	private TrackingService service;
	
	@BeforeClass
	public static void before() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void after() {
		System.out.println("After Class");
	}
	
	@Before
	public void setUp(){
		System.out.println("Before");
		service = new TrackingService();
	}
	
	@After
	public void tearDown(){
		System.out.println("After");
	}

	@Test
	@Ignore
	@Category({GoodTestCategory.class, BadCategory.class})
	public void newTrackingServiceTotalIsZero(){
		assertEquals("Tracking service total was not zero", 0, service.getTotal());
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void whenAddingProteinTotalIncreasesByThatAmount(){
		service.addProtein(10);
//		assertEquals("Protein amount was not correct", 10, service.getTotal());
//		assertThat(service.getTotal(), is(10));
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
		
	}
	
	@Test
	@Category(GoodTestCategory.class)
	public void whenRemovingProteinTotalRemainsZero(){
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
//	@Test(expected = InvalidGoalException.class)
	@Test
	public void whenGoalIsSetToLessThenZeroExceptionIsThrown() throws InvalidGoalException{
		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage(containsString("Goal"));
		service.setGoal(-5);
	}
	
	@Rule
    public Timeout timeout = new Timeout(500);
	
//	@Test(timeout = 500)
	@Test
	public void badTest() {
		for (int i = 0; i < 1000000; i++) {
			service.addProtein(0);
		}
	}
}





























