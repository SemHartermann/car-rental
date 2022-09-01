package db.entities;

public class Car extends Entity {



    private String model;

    private String mark;

    private String carClass;

    private int price;

    private String licensePlate;

    private int driverPrice;

    private boolean transmission;
    private boolean available;

    public int getPrice() {
        return price;
    }

    public int getDriverPrice() {
        return driverPrice;
    }

    public boolean isTransmission() {
        return transmission;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDriverPrice(int driverPrice) {
        this.driverPrice = driverPrice;
    }

    public void setTransmission(boolean transmission) {
        this.transmission = transmission;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    private int yearOfMake;

    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String name) {
        this.model = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getCarPrice() {
        return price;
    }

    public void setCarPrice(int carPrice) {
        this.price = carPrice;
    }
    public int getCarDriverPrice() {
        return driverPrice;
    }

    public void setCarDriverPrice(int carDriverPrice) {
        this.driverPrice = carDriverPrice;
    }

    @Override
    public String toString() {
        return "Car [name=" + model + ", mark=" + mark + ", carClass="
                + carClass + ", carPrice=" + price + ", carDriverPrice="
                + driverPrice + "]";
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
