package db.dao.mysql;

import db.DBManager;
import db.dao.CarDAO;
import db.dao.DaoFactory;
import db.entities.Car;
import db.exceptions.DBException;
import org.junit.*;

import static org.junit.Assert.assertEquals;


public class MySqlCarDaoTest {
    @Test
    public void testAddCar() throws DBException {

        CarDAO carDao = DaoFactory.getCarDaoInstance();

        Car car = new Car();
        car.setId(1);
        car.setModel("Camaro");
        car.setMark("Chevrolet");
        car.setCarClass("S");
        car.setCarPrice(5000);
        car.setCarDriverPrice(5200);

        Car actual = carDao.addCar(car);
        Car expected = car;
        assertEquals(expected, actual);
    }
}
