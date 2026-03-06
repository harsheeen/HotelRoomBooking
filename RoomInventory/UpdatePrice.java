package com.RoomInventory;

import java.util.HashMap;
import java.util.Map;

public class UpdatePrice {
	// Update room price
	static void updatePrice(String roomChoice, double newPrice, Map<String, Double> roomprice) {
		if (roomprice.containsKey(roomChoice)) {
			roomprice.put(roomChoice, newPrice);
			System.out.println("Price for " + roomChoice + " updated to" + newPrice);
		} else {
			System.out.println("Invalid room type!");
		}
	}
}
