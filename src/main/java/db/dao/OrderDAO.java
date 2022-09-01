package db.dao;

import db.entities.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface OrderDAO {
    public Order extractOrder(ResultSet rs);
    public List<Order> findOrders();
    public List<Order> findOrdersByUserId(int userId);
    public Order findOrderById(int id);
    public Order addOrder(Order o);
    public void updateOrderStatus(Order order);
    public void updateOrderStatusRej(Order order);
    public void updateOrderReturn(Order order);
    public void updateOrderStatus(Connection con, Order order);
    public void updateOrderStatusRej(Connection con, Order order);
    public void updateOrderReturn(Connection con, Order order);
}
