
public class ParkingSlot {
    int id;
    boolean isHandicapped;
    boolean isElectric;
    boolean isAvailable;
    int size; // 1 for Sadan, 2 for SUV, 3 for Truck
    public ParkingSlot(int id, int size, boolean
        isElectric, boolean isHandicapped) {
        this.id = id;
        this.size = size; 
        this.isAvailable = true;
        this.isElectric = isElectric;
        this.isHandicapped = isHandicapped;
    }
    
}
