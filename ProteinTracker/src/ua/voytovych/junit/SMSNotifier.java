package ua.voytovych.junit;

import java.io.IOException;

import com.techventus.server.voice.Voice;

public class SMSNotifier implements Notifier {
	private String userName;
	private String password;
	private String numberToMessage;
	
	
	
	public SMSNotifier(String userName, String password, String numberToMessage) {
		this.userName = userName;
		this.password = password;
		this.numberToMessage = numberToMessage;
	}



	@Override
	public boolean send(String message) {
		
		try{
			Voice voice = new Voice(userName, password);
			voice.sendSMS(numberToMessage, message);
		} catch (IOException e){
			return false;
		}
		return true;
	}

}
