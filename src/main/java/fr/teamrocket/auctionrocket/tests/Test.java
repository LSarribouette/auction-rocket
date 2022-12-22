package fr.teamrocket.auctionrocket.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("coucou test");
		System.out.println("(\"2022-12-21T10:15\").substring(0,10)-> "+("2022-12-21T10:15").substring(0,10));
		// TODO Auto-generated method stub

		LocalDate dateStart = LocalDate.parse(("2022-12-21T10:15").substring(0,10));
			
		System.out.println(dateStart);
			
			
//		date-start 2022-12-21T10:15
//		date-end 2022-12-21T10:15
		
//		Integer.parseInt("okok");
//		NumberFormatException
		
		
	}

}
