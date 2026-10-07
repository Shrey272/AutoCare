package model;

public class Vehicle {

    private int vehicleId;
    private int customerId;

    private String customerName;
    private String vehicleNumber;
    private String brand;
    private String model;
    private String vehicleType;

    public Vehicle() {
    }

    public Vehicle(int customerId,
                   String vehicleNumber,
                   String brand,
                   String model,
                   String vehicleType) {

        this.customerId = customerId;
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.model = model;
        this.vehicleType = vehicleType;
    }

    public Vehicle(int vehicleId,
                   int customerId,
                   String vehicleNumber,
                   String brand,
                   String model,
                   String vehicleType) {

        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.model = model;
        this.vehicleType = vehicleType;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}