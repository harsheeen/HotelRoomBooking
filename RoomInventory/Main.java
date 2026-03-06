package com.RoomInventory;
import java.util.*;

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
			case "book" -> {
				System.out.print("Enter room type (Suite/Single/Double): ");
				String roomChoice = sc.nextLine().trim();
				BookRooms.bookRoom(roomChoice,roomCount);
			}
			case "update" -> {
				System.out.print("Enter room type to update price: ");
				String updateRoom = sc.nextLine().trim();
				System.out.print("Enter new price: ");
				double newPrice = sc.nextDouble();
				sc.nextLine(); // consume newline
				UpdatePrice.updatePrice(updateRoom, newPrice,roomPrice);
			}
			case "show" -> ShowAvailability.showAvailability(roomCount);
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
