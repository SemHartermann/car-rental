package db.dao.mysql;


import db.DBManager;
import db.Fields;
import db.dao.DaoFactory;
import db.dao.OrderDAO;
import db.entities.Order;
import db.exceptions.DBException;
import db.exceptions.Messages;
import org.apache.log4j.Logger;
import util.PriceCalculator;
import util.TimeIntervalCalculator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDAO implements OrderDAO {

    private static final Logger LOG = Logger.getLogger(MySqlOrderDAO.class);

    private static final String SQL_FIND_ALL_ORDERS = "SELECT * FROM `order`";

    private static final String SQL_FIND_ORDERS_BY_USER_ID = "SELECT * FROM `order` WHERE user_id=?";

    private static final String SQL_FIND_ORDERS_BY_ID = "SELECT * FROM `order` WHERE id=?";

    private static final String SQL_CREATE_NEW_ORDER = "INSERT INTO `order` (user_id, car_id, driver_status, "
            + "start_date, end_date, price) VALUES (?, ?, ?, ?, ?, ?)";

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
            order.setStartDate(rs.getDate(Fields.ORDER_DATA_ORDER));
            order.setEndDate(rs.getDate(Fields.ORDER_DATA_RETURN));
            order.setPrice(rs.getInt(Fields.ORDER_PRICE));
            order.setStatusId(rs.getInt(Fields.ORDER_STATUS_ID));
            order.setRejectionReason(rs.getString(Fields.ORDER_REJECTION_REASON));
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
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);*/
            try {
                throw new DBException(Messages.ERR_CANNOT_OBTAIN_ORDERS, ex);
            } catch (DBException e) {
                ex.printStackTrace();
                throw new RuntimeException(e);
            }

        } finally {

        }
        return ordersList;
    }

    public List<Order> findOrdersByUserId(int userId){
        List<Order> ordersList = new ArrayList<>();

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_ORDERS_BY_USER_ID);) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ordersList.add(extractOrder(rs));
            }
            /*con.commit();*/
        } catch (SQLException ex) {
            /*throw new DBException(Messages.ERR_CANNOT_OBTAIN_ORDERS_BY_USER_ID, ex);*/
            ex.printStackTrace();
        } finally {

        }
        return ordersList;
    }

    public Order findOrderById(int id){
        Order order = new Order();

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_ORDERS_BY_ID);
             ResultSet rs = pstmt.executeQuery()){

            pstmt.setLong(1, id);
            if (rs.next()) {
                order = extractOrder(rs);
            }
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_ORDER_BY_ID, ex);*/
            ex.printStackTrace();
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

            int days = TimeIntervalCalculator.getDays(order.getStartDate(),order.getEndDate());
            int price = PriceCalculator.getPrice(
                    DaoFactory.getCarDaoInstance().findCarById(order.getCarId()).getCarPrice(),
                    DaoFactory.getCarDaoInstance().findCarById(order.getCarId()).getCarDriverPrice(),
                    days);

            pstmt.setInt(6, price);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            /*rollback(con);*/
            LOG.error(Messages.ERR_CANNOT_CREATE_ORDER, ex);
            ex.printStackTrace();
        } finally {

        }
        return order;
    }

    public void updateOrderStatus(Order order)  {

        try (Connection con = DBManager.getInstance().getConnection();){

            updateOrderStatus(con, order);
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_ORDER_STATUS, ex);*/
            ex.printStackTrace();
        } finally {

        }
    }

    public void updateOrderStatusRej(Order order)  {

        try (Connection con = DBManager.getInstance().getConnection();){

            updateOrderStatusRej(con, order);
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_ORDER_STATUS, ex);*/
            ex.printStackTrace();
        } finally {

        }
    }

    public void updateOrderReturn(Order order)  {

        try (Connection con = DBManager.getInstance().getConnection();){

            updateOrderReturn(con, order);
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_ORDER_STATUS, ex);*/
            ex.printStackTrace();
        } finally {

        }
    }

    public void updateOrderStatus(Connection con, Order order){
        try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_ORDER_STATUS)){
            pstmt.setInt(1, order.getStatusId());
            pstmt.setInt(2, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void updateOrderStatusRej(Connection con, Order order) {
        try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_ORDER_STATUS_REJ)){
            pstmt.setInt(1, order.getStatusId());
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
            pstmt.setInt(k++, order.getStatusId());
            pstmt.setInt(k, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }



}
