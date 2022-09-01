package db.dao;

import db.dao.mysql.*;

public class DaoFactory {

    private static MySqlCarDAO carDAO;
    private static MySqlOrderDAO orderDAO;
    private static MySqlUserDAO userDAO;

    private static MySqlUserInfoDAO userInfoDAO;
    private static MySqlUserInfoBeanDAO userInfBeanDAO;
    private static MySqlOrderBeanDAO orderBeanDAO;

    public static MySqlCarDAO getCarDaoInstance() {
        if (carDAO == null) {
            carDAO = new MySqlCarDAO();
        }
        return carDAO;
    }

    public static MySqlOrderDAO getOrderDaoInstance() {
        if (orderDAO == null) {
            orderDAO = new MySqlOrderDAO();
        }
        return orderDAO;
    }

    public static MySqlUserInfoBeanDAO getUserInfoDaoBeanInstance() {
        if (userInfBeanDAO == null) {
            userInfBeanDAO = new MySqlUserInfoBeanDAO();
        }
        return userInfBeanDAO;
    }

    public static MySqlUserInfoDAO getUserInfoDAOInstance() {
        if (userInfoDAO == null) {
            userInfoDAO = new MySqlUserInfoDAO();
        }
        return userInfoDAO;
    }

    public static MySqlOrderBeanDAO getOrderBeanDAO() {
        if (orderBeanDAO == null) {
            orderBeanDAO = new MySqlOrderBeanDAO();
        }
        return orderBeanDAO;
    }

    public static MySqlUserDAO getUserDaoInstance() {
        if (userDAO == null) {
            userDAO = new MySqlUserDAO();
        }
        return userDAO;
    }

}
