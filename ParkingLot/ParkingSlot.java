package ParkingLot;
public class ParkingSlot {
    int id;
    boolean isAvailable;
    int size; // 1 for Sadan, 2 for SUV, 3 for Truck
    public ParkingSlot(int id, int size) {
        this.id = id;
        this.size = size; 
        this.isAvailable = true;
    }
    
}
