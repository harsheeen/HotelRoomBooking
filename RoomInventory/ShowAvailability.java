package com.RoomInventory;

import java.util.Map;

public class ShowAvailability {
	public static void showAvailability(Map<String, Integer> roomCount, Map<String, Double> roomPrice) {
		System.out.println("\n Current Room Availability:");
		roomCount.forEach((room, count) -> 
		System.out.println(room + " → " + count + " rooms")	);
	}

}
