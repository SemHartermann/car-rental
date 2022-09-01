package util;

public class PriceCalculator {

    public static int getPrice (int carPrice, int driverPrice, int orderDays){
        return (carPrice+driverPrice)*orderDays;
    }

}
