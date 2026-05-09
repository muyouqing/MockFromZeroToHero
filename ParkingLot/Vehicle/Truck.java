package Vehicle;
public class Truck implements Vehicle {
    String templateNumer;
    boolean isElectric;
    public Truck(String templateNumber, boolean isElectric) {
        this.templateNumer = templateNumber;
        this.isElectric = isElectric;
    }
    public Boolean isElectric() {
        return this.isElectric;
    }
    public VehicleType getVehicleType() {
        return VehicleType.Truck;
    }
    public Double getPrice() {
        return 3.0;
    }
    public Integer getSize() {
        return 3;
    }
}
