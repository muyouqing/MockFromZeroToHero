package Vehicle;
public class SUV implements Vehicle {
    String templateNumber;
    boolean isElectric;

    public SUV(String templateNumber,boolean isElectric) {
        this.templateNumber = templateNumber;
        this.isElectric = isElectric;
    }
    public Boolean isElectric() {
        return this.isElectric;
    }
    public VehicleType getVehicleType() {
        return VehicleType.SUV;
    }
    public Double getPrice() {
        return 2.0;
    }
    public Integer getSize() {
        return 2;
    }
}
