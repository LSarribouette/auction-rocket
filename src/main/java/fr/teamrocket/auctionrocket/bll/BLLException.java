package fr.teamrocket.auctionrocket.bll;
//TODO: oui.
public class BLLException extends Exception {
	
	public BLLException() {
		super();
	}
	
	public BLLException(String message) {
		super(message);
	}
	
	public BLLException(String message, Throwable exception) {
		super(message, exception);
	}
	
	public String getMessage() {
		return "BLL - "+super.getMessage();
	}

}
