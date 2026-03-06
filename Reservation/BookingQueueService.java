package com.Reservation;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BookingQueueService {
    // Thread-safe queue
    private final BlockingQueue<Reservation> bookingQueue = new LinkedBlockingQueue<>();

    // Producer: add booking request
    public void addRequest(String guestName, String roomType) {
        Reservation r = new Reservation(guestName, roomType);
        try {
            bookingQueue.put(r); // enqueue safely
            System.out.println("📥 Request added for " + guestName + " (" + roomType + ")");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Consumer: process requests with Thread.sleep()
    public void processRequests() {
        while (true) {
            try {
                Reservation r = bookingQueue.take(); // dequeue safely
                System.out.println("Processing booking for " + r.guestName + " (" + r.roomType + ")");
                Thread.sleep(2000); // simulate processing time
                System.out.println("Completed booking for " + r.guestName);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}