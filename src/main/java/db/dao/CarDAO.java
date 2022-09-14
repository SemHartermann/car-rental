package db.dao;

import db.entities.Car;

import java.sql.ResultSet;
import java.util.List;

public interface CarDAO {
    public Car addCar(Car c);
    public Car extractCar(ResultSet rs) ;
    public List<Car> findCars() ;
    public Car findCarById(int id) ;
    public List<Car> findCarsInRent() ;
    public List<Car> findAvailableCars();
    public String toString();
}
