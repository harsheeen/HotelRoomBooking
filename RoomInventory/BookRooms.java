package com.RoomInventory;

import java.util.Map;

public class BookRooms {
	 public static void bookRoom(String roomChoice,Map<String, Integer> roomCount) {
		if (!roomCount.containsKey(roomChoice)) {
			System.out.println(" Invalid room type!");
		}

		int available = roomCount.get(roomChoice);
		if (available > 0) {
			roomCount.put(roomChoice, available - 1);
			System.out.println( roomChoice + " booked successfully. Remaining: " + (available - 1));
		} else {
			System.out.println(" NO ROOMS AVAILABLE for " + roomChoice);
		}
	}
}
