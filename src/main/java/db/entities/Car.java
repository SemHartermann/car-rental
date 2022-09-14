package db.entities;

import java.io.Serializable;

public class Car extends Entity {
    private String model;
    private String mark;
    private String carClass;
    private int price;
    private int driverPrice;

    public int getPrice() {
        return price;
    }

    public int getDriverPrice() {
        return driverPrice;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDriverPrice(int driverPrice) {
        this.driverPrice = driverPrice;
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

}
