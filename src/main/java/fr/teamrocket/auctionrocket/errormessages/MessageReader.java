package fr.teamrocket.auctionrocket.errormessages;

import java.util.ResourceBundle;

public class MessageReader {
	
	private static ResourceBundle rb;
	
	static {
		try {
			rb = ResourceBundle.getBundle("fr.teamrocket.auctionrocket.errormessages.error_messages");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getErrorMessages(int code) {
		String message="";
		
		if(rb!=null) {
			try {
				message = rb.getString(String.valueOf(code));
			} catch (Exception e) {
				e.printStackTrace();
				message = code + "UNKNOWN ERROR CAUGHT";
			}
		} else {
			message = "UNABLE TO READ THE FILE error_messages";
		}
		
		return message;
	}

}
