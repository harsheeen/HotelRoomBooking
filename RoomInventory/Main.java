package com.RoomInventory;
import java.util.*;
/*
Project - HotelRoomBookingApp
UseCase2 -   Room Search & Availability Check
Key Concepts -
*Read-only access
*Defensive checks
*Availability validation

Key Requirements -
*Display available room types
*Show pricing and amenities
*Prevent booking unavailable rooms

@author HarsheenKaur
@version 2.0

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

		//display options
		while (true) {
			System.out.print("\nEnter command (book/update/show/exit): ");
			String command = sc.nextLine().trim().toLowerCase();

			// Advanced switch with arrow syntax
			switch (command) {
			case "book" -> {		//book choice between suite, single, double
				System.out.print("Enter room type (Suite/Single/Double): ");
				String roomChoice = sc.nextLine().trim();
				BookRooms.bookRoom(roomChoice,roomCount);
			}
			case "update" -> {		//update the price of certain rooms
				System.out.print("Enter room type to update price: ");
				String updateRoom = sc.nextLine().trim();
				System.out.print("Enter new price: ");
				double newPrice = sc.nextDouble();
				sc.nextLine(); // consume newline
				UpdatePrice.updatePrice(updateRoom, newPrice,roomPrice);
			}
			case "show" -> ShowAvailability.showAvailability(roomCount); 	//display the current status of the room
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
