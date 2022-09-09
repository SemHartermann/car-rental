package db.dao.mysql;

import db.DBManager;
import db.Fields;
import db.dao.OrderBeanDAO;
import db.entities.UserOrderBean;
import db.exceptions.DBException;
import db.exceptions.Messages;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderBeanDAO implements OrderBeanDAO {

    private static final Logger LOG = Logger.getLogger(MySqlOrderBeanDAO.class);
    private static final String SQL_GET_USER_ORDER_BEANS = "SELECT o.id, i.last_name, i.first_name, "
            + "c.model, o.driver_status, o.start_date, o.end_date, o.price, "
            + "s.name AS status_name, o.rejection_reason, o.damage, o.price_for_repairs "
            + "FROM `order` o, car c, order_status s,  user_info i WHERE o.user_id=i.user_id "
            + "AND o.car_id=c.id AND o.status_id=s.id;";

    private static final String SQL_GET_USER_ORDER_BEANS_BY_USER_ID = "SELECT o.id, i.last_name, i.first_name, "
            + "c.model, o.driver_status, o.start_date, o.end_date, o.price, "
            + "s.name AS status_name, o.rejection_reason, o.damage, o.price_for_repairs "
            + "FROM `order` o, car c, order_status s,  user_info i WHERE o.user_id=i.user_id "
            + "AND o.car_id=c.id AND o.status_id=s.id AND o.user_id=?;";



    public List<UserOrderBean> getUserOrderBeans() throws DBException {

        List<UserOrderBean> orderUserBeanList = new ArrayList<UserOrderBean>();

        try (Connection con = DBManager.getInstance().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_USER_ORDER_BEANS);){

            while (rs.next()) {
                orderUserBeanList.add(extractUserOrderBean(rs));
            }
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);*/
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_ORDER_BEANS, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_ORDER_BEANS,
                    ex);
        } finally {

        }
        return orderUserBeanList;
    }

    public List<UserOrderBean> getUserOrderBeansByUserId(int userId) throws DBException {
        List<UserOrderBean> orderUserBeanList = new ArrayList<UserOrderBean>();


        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_GET_USER_ORDER_BEANS_BY_USER_ID);){

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                orderUserBeanList.add(extractUserOrderBean(rs));
            }
            /*con.commit();*/
        } catch (SQLException ex) {
            /*rollback(con);*/
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_ORDER_BEANS, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_ORDER_BEANS,
                    ex);
        } finally {

        }
        return orderUserBeanList;
    }

    public UserOrderBean extractUserOrderBean(ResultSet rs) throws SQLException {
        UserOrderBean bean = new UserOrderBean();
        bean.setId(rs.getInt(Fields.USER_ORDER_BEAN_ORDER_ID));
        bean.setUserLastName(rs
                .getString(Fields.USER_ORDER_BEAN_USER_LAST_NAME));
        bean.setUserFirstName(rs
                .getString(Fields.USER_ORDER_BEAN_USER_FIRST_NAME));
        bean.setCarName(rs.getString(Fields.USER_ORDER_BEAN_CAR_MODEL));
        bean.setDriverStatus(rs
                .getBoolean(Fields.USER_ORDER_BEAN_DRIVER_STATUS));
        bean.setStartDate(rs.getDate(Fields.USER_ORDER_BEAN_DATE_START));
        bean.setEndDate(rs.getDate(Fields.USER_ORDER_BEAN_DATE_END));
        bean.setOrderPrice(rs.getInt(Fields.USER_ORDER_BEAN_ORDER_PRICE));
        bean.setStatusName(rs.getString(Fields.USER_ORDER_BEAN_STATUS_NAME));
        bean.setRejectionReason(rs
                .getString(Fields.USER_ORDER_BEAN_REJECTION_REASON));
        bean.setDamage(rs.getBoolean(Fields.USER_ORDER_BEAN_DAMAGE));
        bean.setPriceForRepairs(rs
                .getInt(Fields.USER_ORDER_BEAN_PRICE_FOR_REPAIRS));
        return bean;
    }

}
