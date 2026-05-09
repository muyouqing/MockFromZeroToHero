import java.util.List;

public class Level {
    List<ParkingSlot> parkingSlots;
    public Level(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
}
