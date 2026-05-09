package Vehicle;
public interface Vehicle {
    Double getPrice();
    Integer getSize();
    VehicleType getVehicleType();
    Boolean isElectric();
    default void getTemplates() {
        // Default implementation
    }
}