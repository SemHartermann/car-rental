package db.dao.mysql;


import db.DBManager;
import db.Fields;
import db.dao.DaoFactory;
import db.dao.OrderDAO;
import db.entities.Car;
import db.entities.Order;
import db.exceptions.DBException;
import db.exceptions.Messages;
import org.apache.log4j.Logger;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDAO implements OrderDAO {

    private static final Logger LOG = Logger.getLogger(MySqlOrderDAO.class);

    private static final String SQL_FIND_ALL_ORDERS = "SELECT * FROM `order`";

    private static final String SQL_FIND_ORDERS_BY_USER_ID = "SELECT * FROM `order` WHERE user_id=?";

    private static final String SQL_FIND_ORDERS_BY_ID = "SELECT * FROM `order` WHERE id=?";

    private static final String SQL_CREATE_NEW_ORDER = "INSERT INTO `order` (user_id, car_id, driver_status, "
            + "start_date, end_date, price, status_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_ORDER_STATUS = "UPDATE `order` SET status_id=? WHERE id=?";

    private static final String SQL_UPDATE_ORDER_STATUS_REJ = "UPDATE `order` SET status_id=?, rejection_reason=? WHERE id=?";

        private static final String SQL_UPDATE_ORDER_RETURN = "UPDATE `order` SET status_id=?, damage=?, price_for_repairs=? WHERE id=?";

    public Order extractOrder(ResultSet rs) {
        Order order = new Order();
        try {
            order.setId(rs.getInt(Fields.ENTITY_ID));
            order.setUserId(rs.getInt(Fields.ORDER_USER_ID));
            order.setCarId(rs.getInt(Fields.ORDER_CAR_ID));
            order.setDriverStatus(rs.getBoolean(Fields.ORDER_DRIVER_STATUS));
            order.setStartDate(rs.getDate(Fields.ORDER_DATE_START));
            order.setEndDate(rs.getDate(Fields.ORDER_DATE_END));
            order.setPrice(rs.getInt(Fields.ORDER_PRICE));
            order.setStatusId(rs.getInt(Fields.ORDER_STATUS_ID));
            order.setRejectionReason(rs.getString(Fields.ORDER_REJECTION_REASON));
            order.setDamage(rs.getBoolean(Fields.ORDER_DAMAGE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> findOrders(){
        List<Order> ordersList = new ArrayList<>();

        try (Connection con = DBManager.getInstance().getConnection();
             Statement stmt = con.createStatement();){
            ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_ORDERS);
            while (rs.next()) {
                ordersList.add(extractOrder(rs));
            }

        } catch (SQLException ex) {
            try {
                throw new DBException(Messages.ERR_CANNOT_OBTAIN_ORDERS, ex);
            } catch (DBException e) {
                throw new RuntimeException(e);
            }

        } finally {

        }
        return ordersList;
    }

    public List<Order> findOrdersByUserId(int userId) throws DBException {
        List<Order> ordersList = new ArrayList<>();

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_ORDERS_BY_USER_ID);) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ordersList.add(extractOrder(rs));
            }

        } catch (SQLException ex) {
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_ORDERS_BY_USER_ID, ex);
        } finally {

        }
        return ordersList;
    }

    public Order findOrderById(int id) throws DBException {
        Order order = new Order();

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_ORDERS_BY_ID);){

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                order = extractOrder(rs);
            }

        } catch (SQLException ex) {

            throw new DBException(Messages.ERR_CANNOT_OBTAIN_ORDER_BY_ID, ex);

        } finally {


        }
        return order;
    }

    public Order addOrder(Order o){
        Order order = o;

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_CREATE_NEW_ORDER)){

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getCarId());
            pstmt.setBoolean(3, order.isDriverStatus());
            LOG.info(order.getStartDate());
            pstmt.setDate(4, order.getStartDate());
            pstmt.setDate(5, order.getEndDate());

            int days = (int) DateUtil.fullDaysBetweenDates(
                    order.getStartDate(), order.getEndDate());
            LOG.info("days between dates --> "+days);
            int price = calc(order) * days;

            pstmt.setInt(6, price);
            pstmt.setInt(7, order.getStatusId()+1);
            pstmt.executeUpdate();
        } catch (SQLException ex) {

            LOG.error(Messages.ERR_CANNOT_CREATE_ORDER, ex);

        } catch (DBException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return order;
    }

    private int calc(Order order) throws DBException {
        int price;
        Car car = DaoFactory.getCarDaoInstance().findCarById(order.getCarId());
        if (order.isDriverStatus()) {
            price = car.getCarDriverPrice();
        } else {
            price = car.getCarPrice();
        }
        return price;
    }

    public void updateOrderStatus(Order order) throws DBException {

        try (Connection con = DBManager.getInstance().getConnection();){

            updateOrderStatus(con, order);

        } catch (SQLException ex) {

            throw new DBException(Messages.ERR_CANNOT_UPDATE_ORDER_STATUS, ex);
        } finally {

        }
    }

    public void updateOrderStatusRej(Order order) throws DBException {

        try (Connection con = DBManager.getInstance().getConnection();){

            updateOrderStatusRej(con, order);

        } catch (SQLException ex) {

            throw new DBException(Messages.ERR_CANNOT_UPDATE_ORDER_STATUS, ex);

        } finally {

        }
    }

    public void updateOrderReturn(Order order) throws DBException {

        try (Connection con = DBManager.getInstance().getConnection();){

            updateOrderReturn(con, order);

        } catch (SQLException ex) {

            throw new DBException(Messages.ERR_CANNOT_UPDATE_ORDER_STATUS, ex);

        } finally {

        }
    }

    public void updateOrderStatus(Connection con, Order order){
        try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_ORDER_STATUS)){
            pstmt.setInt(1, order.getStatusId()+1);
            pstmt.setInt(2, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void updateOrderStatusRej(Connection con, Order order) {
        try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_ORDER_STATUS_REJ)){
            pstmt.setInt(1, order.getStatusId()+1);
            pstmt.setString(2, order.getRejectionReason());
            pstmt.setInt(3, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void updateOrderReturn(Connection con, Order order){

        try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_ORDER_RETURN);){

            int k = 1;
            pstmt.setInt(k++, order.getStatusId()+1);
            pstmt.setBoolean(k++, order.isDamage());
            pstmt.setInt(k++, order.getPriceForRepairs());
            pstmt.setInt(k, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }



}
