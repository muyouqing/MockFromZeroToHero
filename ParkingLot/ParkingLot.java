package ParkingLot;
import java.time.Instant;
import java.util.*;

import ParkingLot.Vehicle.SUV;
import ParkingLot.Vehicle.Sadan;
import ParkingLot.Vehicle.Truck;
import ParkingLot.Vehicle.Vehicle;

public class ParkingLot {
    List<Level> levels;
    Map<Vehicle, Integer> vehicleSizeMap;

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
        this.vehicleSizeMap = new HashMap<>();
        vehicleSizeMap.put(new Sadan(""), 1);
        vehicleSizeMap.put(new SUV(""), 2);
        vehicleSizeMap.put(new Truck(""), 3);
    }
    public Ticket park(Vehicle vehicle) {
        int size = vehicleSizeMap.get(vehicle);
        for (Level level : levels) {
            for (ParkingSlot slot : level.getParkingSlots()) {
                if (slot.isAvailable && size <= slot.size) {
                    slot.isAvailable = false;
                    return new Ticket(new Random().nextInt(), vehicle, slot);
                }
            }
        }
        return null; // No available slot
    }
    public Double checkout(Ticket ticket) {
        ParkingSlot slot = ticket.parkingSlot;
        slot.isAvailable = true;
        double price = calculatePrice(ticket);
        return price;
    }
    private double calculatePrice(Ticket ticket) {
        long duration = Instant.now().toEpochMilli() - ticket.createdAt.toEpochMilli();
        double pricePerHour = 0;
        if (ticket.vehicle instanceof Sadan) {
            pricePerHour = 2.0;
        } else if (ticket.vehicle instanceof SUV) {
            pricePerHour = 3.0;
        } else if (ticket.vehicle instanceof Truck) {
            pricePerHour = 4.0;
        }
        return (duration / (1000 * 60 * 60)) * pricePerHour;
    }
}
