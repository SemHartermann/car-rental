package db.dao.mysql;

import db.DBManager;
import db.Fields;
import db.dao.CarDAO;
import db.entities.Car;
import db.exceptions.DBException;
import db.exceptions.Messages;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCarDAO implements CarDAO {

    private static final Logger LOG = Logger.getLogger(MySqlCarDAO.class);

    private static final String SQL_CREATE_NEW_CAR = "INSERT INTO car (model, mark, class, price, driver_price) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_FIND_ALL_CARS = "SELECT * FROM car";

    private static final String SQL_FIND_CAR_BY_ID = "SELECT * FROM car WHERE id=?";

    private static final String SQL_UPDATE_CAR_PRICE = "UPDATE car SET price=?, driver_price=? WHERE id=?";

    private static final String SQL_DELETE_CAR_BY_ID = "DELETE FROM car WHERE id=?";

    private static final String SQL_GET_CARS_IN_RENT = "select c.id, c.model, c.mark, c.class, c.price, c.driver_price"
            +"  from car c, `order` o "
            +"where c.id=o.car_id and (o.status_id=2 or o.status_id=4 or o.status_id=1);";

    
    public boolean deleteCarById(int id) throws DBException {
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_DELETE_CAR_BY_ID)) {

            pstmt.setInt(1, id);
            int count = pstmt.executeUpdate();

            if (count < 1) {
                return false;
            }
            /*con.commit();*/
        } catch (SQLException ex) {

            throw new DBException(Messages.ERR_CANNOT_DELETE_CAR_BY_ID, ex);
        } finally {
        }
        return true;
    }

    public Car addCar(Car c) {
        Car car = c;

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_CREATE_NEW_CAR)) {
            pstmt.setString(1, car.getModel());
            pstmt.setString(2, car.getMark());
            pstmt.setString(3, car.getCarClass());
            pstmt.setInt(4, car.getCarPrice());
            pstmt.setInt(5, car.getCarDriverPrice());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            /*LOG.error(Messages.ERR_CANNOT_CREATE_CAR, ex);*/
            ex.printStackTrace();
        } finally {
            /*close(pstmt);
            commitAndCloseConnection(con);*/

        }
        return car;
    }

    public Car extractCar(ResultSet rs) {
        Car car = new Car();
        try {
            car.setId(rs.getInt(Fields.ENTITY_ID));
            car.setModel(rs.getString(Fields.CAR_MODEL));
            car.setMark(rs.getString(Fields.CAR_MARK));
            car.setCarClass(rs.getString(Fields.CAR_CLASS));
            car.setCarPrice(rs.getInt(Fields.CAR_PRICE));
            car.setCarDriverPrice(rs.getInt(Fields.CAR_DRIVER_PRICE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public List<Car> findCars() {
        List<Car> carList = new ArrayList<Car>();

        try (Connection con = DBManager.getInstance().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_CARS)) {

            while (rs.next()) {
                carList.add(extractCar(rs));
            }
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CARS, ex);*/
            ex.printStackTrace();
        } finally {

        }
        return carList;
    }

    public Car findCarById(int id) {
        Car car = null;
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_CAR_BY_ID);) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                car = extractCar(rs);
            }
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);*/
            ex.printStackTrace();
        } finally {

        }
        return car;
    }


    public List<Car> findCarsInRent() {
        List<Car> carList = new ArrayList<>();

        try (Connection con = DBManager.getInstance().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_CARS_IN_RENT)) {
            while (rs.next()) {
                carList.add(extractCar(rs));
            }
            /*con.commit();*/
        } catch (SQLException ex) {
//            rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CARS, ex);
            ex.printStackTrace();
        } finally {

        }
        return carList;
    }

    /**
     * Returns available cars.
     *
     * @return List of car entities.
     * @throws DBException
     */
    public List<Car> findAvailableCars() {
        List<Car> allCars = findCars();
        List<Car> carsInRent = findCarsInRent();

        int[] masId = new int[carsInRent.size()];

        for (int i = 0; i < masId.length; i++) {
            masId[i] = carsInRent.get(i).getId();
        }

        for (int i = 0; i < masId.length; i++) {
            for (int j = 0; j < allCars.size(); j++) {
                if (masId[i] == allCars.get(j).getId()) {
                    allCars.remove(j);
                }
            }
        }
        return allCars;
    }

    private void updateCarPrice(Connection con, Car car) throws SQLException {
        try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_CAR_PRICE);) {
            int k = 1;
            pstmt.setInt(k++, car.getCarPrice());
            pstmt.setInt(k++, car.getCarDriverPrice());
            pstmt.setInt(k, car.getId());
            pstmt.executeUpdate();
        } finally {

        }
    }

    public void updateCarPrice(Car car) throws DBException {

        try (Connection con = DBManager.getInstance().getConnection();){

            updateCarPrice(con, car);
            /*con.commit();*/
        } catch (SQLException ex) {

            throw new DBException(Messages.ERR_CANNOT_UPDATE_CAR, ex);
        } finally {

        }
    }



}
