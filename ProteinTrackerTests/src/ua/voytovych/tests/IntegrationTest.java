package ua.voytovych.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techventus.server.voice.Voice;
import com.techventus.server.voice.datatypes.records.SMSThread;

import ua.voytovych.junit.InvalidGoalException;
import ua.voytovych.junit.SMSNotifier;
import ua.voytovych.junit.TrackingService;

public class IntegrationTest {
	private Voice voice;
	
	@Before
	public void setUp() throws IOException {
		voice = new Voice("*****r@gmail.com", "********", "********");
	}
	
	@Test
	public void goalMetShouldSendNotification() throws IOException, InvalidGoalException{
		TrackingService service = new TrackingService(new SMSNotifier("*****r@gmail.com", "********", "********"));
		service.setGoal(50);
		service.addProtein(51);
		
		assertTrue(voice.getSMS().contains("goal met"));
	}
	
	@After
	public void tearDown() throws IOException {
		for (SMSThread thread : voice.getSMSThreads()) {
			voice.deleteMessage(thread.getId());
		}
	}
}
