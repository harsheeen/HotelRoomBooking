package com.RoomInventory;

import java.util.Map;

public class InitialiseRooms {
	public static void initializeRooms(Map<String, Integer> roomCount , Map<String, Double> roomPrice ) {
		roomCount.put("Suite", 3);
		roomCount.put("Single", 13);
		roomCount.put("Double", 15);

		roomPrice.put("Suite", 15000.00);
		roomPrice.put("Single", 9000.00);
		roomPrice.put("Double", 12000.00);
	}
}
