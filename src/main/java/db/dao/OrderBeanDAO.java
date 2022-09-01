package db.dao;

import db.entities.UserOrderBean;
import db.exceptions.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface OrderBeanDAO {
    public List<UserOrderBean> getUserOrderBeans() throws DBException;
    public List<UserOrderBean> getUserOrderBeansByUserId(int userId) throws DBException;
    public UserOrderBean extractUserOrderBean(ResultSet rs) throws SQLException;
    }
