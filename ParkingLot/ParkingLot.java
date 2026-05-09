
import java.time.Instant;
import java.util.*;
import Vehicle.*;

public class ParkingLot {
    List<Level> levels;
    Map<VehicleType, Integer> vehicleSizeMap;

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
        this.vehicleSizeMap = new HashMap<>();
        vehicleSizeMap.put(VehicleType.Sadan, 1);
        vehicleSizeMap.put(VehicleType.SUV, 2);
        vehicleSizeMap.put(VehicleType.Truck, 3);
    }
    public Ticket park(Vehicle vehicle, boolean needHandicapped) {
        boolean needElectric = vehicle.isElectric();
        int size = vehicleSizeMap.get(vehicle.getVehicleType());
        for (Level level : levels) {
            for (ParkingSlot slot : level.getParkingSlots()) {
                //handicapped slot
                if(needHandicapped && slot.isHandicapped && slot.isAvailable) {
                    slot.isAvailable = false;
                    return new Ticket(new Random().nextInt(), vehicle, slot);

                }else {
                    //electric slot
                    if(needElectric && slot.isElectric && slot.isAvailable) {
                        slot.isAvailable = false;
                        return new Ticket(new Random().nextInt(), vehicle, slot);

                    }else {
                        if(slot.size >= size && slot.isAvailable) {
                            slot.isAvailable = false;
                            return new Ticket(new Random().nextInt(), vehicle, slot);
                        }
                    }
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
