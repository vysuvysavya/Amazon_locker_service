package com.gb.amazonlocker;

import java.util.List;
import java.util.UUID;  // Import UUID to generate unique order IDs

import com.gb.amazonlocker.model.GeoLocation;
import com.gb.amazonlocker.model.Item;
import com.gb.amazonlocker.model.Locker;
import com.gb.amazonlocker.model.LockerSize;
import com.gb.amazonlocker.repository.OrderRepository;
import com.gb.amazonlocker.service.LockerService;

public class AmazonLockerMain {
    public static void main(String[] args) {
        // Step 1: Create Order
        // Generate a unique order ID using UUID
        String orderId = "order" + UUID.randomUUID().toString(); // Unique order ID

        Item item1 = new Item();
        item1.setId("item1");
        item1.setQuantity(2); // Quantity of item1

        Item item2 = new Item();
        item2.setId("item2");
        item2.setQuantity(1); // Quantity of item2

        List<Item> items = List.of(item1, item2); // List of items in the order
        GeoLocation deliveryGeoLocation = new GeoLocation(2434.02, 13742.34); // Order delivery location

        // Create the order and add it to the repository
        OrderRepository.createOrder(orderId, items, deliveryGeoLocation);
        System.out.println("Order created: " + orderId);

        // Step 2: Assign a locker based on order's delivery location and item size
        LockerSize lockerSize = LockerSize.M; // Assuming size M for the items
        LockerService lockerService = new LockerService();
        Locker assignedLocker = lockerService.getLocker(lockerSize, deliveryGeoLocation);

        if (assignedLocker != null) {
            System.out.println("Locker assigned: " + assignedLocker.getId());
            System.out.println("Locker location: " + assignedLocker.getGeoLocation());
        } else {
            System.out.println("No locker available for the specified size and location.");
        }
    }
}
