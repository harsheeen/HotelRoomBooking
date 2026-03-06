package com.RoomInventory;
import java.util.*;
/*
Project - HotelRoomBookingApp
UseCase 1 -   Room Inventory Setup & Management
Key Concepts
*Fast lookup
*Centralized inventory
*Data consistency

Key Requirements
*Initialize room types (Single, Double, Suite)
*Store room counts and prices
*Support dynamic inventory updates
*Provide real-time availability status

@author HarsheenKaur
@version 1.0

*/
public class Main {
	static final Map<String, Integer> roomCount = new HashMap<>();
	static final Map<String, Double> roomPrice = new HashMap<>();

	public static void main(String[] args) {
		// Initialize inventory
		InitialiseRooms.initializeRooms(roomCount,roomPrice);

		Scanner sc = new Scanner(System.in);


		System.out.println("Welcome to Hotel Inventory System!");
		ShowAvailability.showAvailability(roomCount);

		while (true) {
			System.out.print("\nEnter command (book/update/show/exit): ");
			String command = sc.nextLine().trim().toLowerCase();

			// Advanced switch with arrow syntax
			switch (command) {
			case "book" -> {                        //book room between suite, single, double
				System.out.print("Enter room type (Suite/Single/Double): ");
				String roomChoice = sc.nextLine().trim();
				BookRooms.bookRoom(roomChoice,roomCount);
			}
			case "update" -> {						//update the price of the rooms
				System.out.print("Enter room type to update price: ");
				String updateRoom = sc.nextLine().trim();
				System.out.print("Enter new price: ");
				double newPrice = sc.nextDouble();
				sc.nextLine(); // consume newline
				UpdatePrice.updatePrice(updateRoom, newPrice,roomPrice);
			}
			
			case "exit" -> {
				System.out.println("Exiting system. Goodbye!");
				sc.close();
				return;
			}
			default -> System.out.println("Invalid command! Try again.");
			}
		}
	}
}
