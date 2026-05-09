
import java.time.Instant;

import Vehicle.Vehicle;


public class Ticket {
    int id;
    Vehicle vehicle;
    ParkingSlot parkingSlot;
    Instant createdAt;
    public Ticket(int id, Vehicle vehicle, ParkingSlot parkingSlot) {
        this.id = id;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.createdAt = Instant.now();
    }
}
