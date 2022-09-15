package db.dao;

import db.entities.Order;
import db.exceptions.DBException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface OrderDAO {
    public Order extractOrder(ResultSet rs);
    public List<Order> findOrders();
    public List<Order> findOrdersByUserId(int userId) throws DBException;
    public Order findOrderById(int id) throws DBException;
    public Order addOrder(Order o);
    public void updateOrderStatus(Order order) throws DBException;
    public void updateOrderStatusRej(Order order) throws DBException;
    public void updateOrderReturn(Order order) throws DBException;
    public void updateOrderStatus(Connection con, Order order);
    public void updateOrderStatusRej(Connection con, Order order);
    public void updateOrderReturn(Connection con, Order order);
}
