package com.RoomInventory;

import java.util.Map;

public class ShowAvailability {
	static void showAvailability(Map<String, Integer> roomCount) {
		System.out.println("\n Current Room Availability:");
		roomCount.forEach((room, count) -> 
		System.out.println(room + " → " + count + " rooms")	);
	}

}
