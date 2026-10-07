package model;

public class Mechanic {

    private int mechanicId;
    private String name;
    private String mobile;
    private String specialization;

    public Mechanic() {
    }

    public Mechanic(String name,
                    String mobile,
                    String specialization) {

        this.name = name;
        this.mobile = mobile;
        this.specialization = specialization;
    }

    public Mechanic(int mechanicId,
                    String name,
                    String mobile,
                    String specialization) {

        this.mechanicId = mechanicId;
        this.name = name;
        this.mobile = mobile;
        this.specialization = specialization;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(
            String specialization) {

        this.specialization =
                specialization;
    }
}