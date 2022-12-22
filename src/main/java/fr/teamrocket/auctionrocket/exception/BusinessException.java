package fr.teamrocket.auctionrocket.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	private List<Integer> errorCodeList;

	public List<Integer> getErrorCodeList() {
		return errorCodeList;
	}
	
	public BusinessException() {
		errorCodeList = new ArrayList<>();
	}
	
	public void addError(int code) {
		if(!errorCodeList.contains(code)) {
			errorCodeList.add(code);
		}
	}
	
	public boolean hasErrors() {
		return !errorCodeList.isEmpty();
	}
}
