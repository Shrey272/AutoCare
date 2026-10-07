package model;

public class Bill {

    private int billId;
    private int bookingId;

    private double amount;

    private String paymentStatus;
    private String paymentDate;

    private String customerName;
    private String vehicleNumber;
    private String serviceName;

    public Bill() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(
            String paymentStatus) {

        this.paymentStatus =
                paymentStatus;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(
            String paymentDate) {

        this.paymentDate =
                paymentDate;
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
}