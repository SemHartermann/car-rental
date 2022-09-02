package util;

import db.entities.Order;
import db.exceptions.DBException;

public class PriceCalculator {

    public static int getPrice (int carPrice, int driverPrice, int orderDays){
        return (carPrice+driverPrice)*orderDays;
    }

    /*private int calc(Order order) throws DBException {

        int price = 0;
        Car car = manager.findCarById(order.getCarId());
        if (order.isDriverStatus()) {
            price = car.getCarDriverPrice();
        } else {
            price = car.getCarPrice();
        }
        return price;
    }*/

}
