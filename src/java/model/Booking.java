package model;

public class Booking {

    private int bookingId;

    private int customerId;
    private int vehicleId;
    private int serviceId;
    private int mechanicId;

    private String bookingDate;
    private String status;

    private String customerName;
    private String vehicleNumber;
    private String serviceName;
    private String mechanicName;

    public Booking() {
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(
            String bookingDate) {

        this.bookingDate =
                bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(
            String customerName) {

        this.customerName =
                customerName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(
            String vehicleNumber) {

        this.vehicleNumber =
                vehicleNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(
            String serviceName) {

        this.serviceName =
                serviceName;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(
            String mechanicName) {

        this.mechanicName =
                mechanicName;
    }
}