
import java.time.Instant;
import java.util.*;
import Vehicle.*;

public class ParkingLot {
    List<Level> levels;
    Map<VehicleType, Integer> vehicleSizeMap;

    public ParkingLot(List<Level> levels) {
        this.levels = levels;
    }
    public Ticket park(Vehicle vehicle, boolean needHandicapped) {
        boolean needElectric = vehicle.isElectric();
        int size = vehicle.getSize();
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
        double pricePerHour = ticket.vehicle.getPrice();
        return (duration / (1000 * 60 * 60)) * pricePerHour;
    }
}
