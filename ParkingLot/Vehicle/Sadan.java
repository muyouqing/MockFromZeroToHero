package Vehicle;
public class Sadan implements Vehicle {
    String templateNumber;
    boolean isElectric;
    public Sadan(String templateNumber, boolean isElectric) {
        this.templateNumber = templateNumber;
        this.isElectric = isElectric;
    }
    public Boolean isElectric() {
        return this.isElectric;
    }
    public VehicleType getVehicleType() {
        return VehicleType.Sadan;
    }
    public Double getPrice() {
        return 1.0;
    }
    public Integer getSize() {
        return 1;
    }
}
