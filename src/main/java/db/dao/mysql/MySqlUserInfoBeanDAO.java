package db.dao.mysql;

import db.DBManager;
import db.Fields;
import db.dao.UserInfoBeanDAO;
import db.entities.UserInfoBean;
import db.exceptions.DBException;
import db.exceptions.Messages;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserInfoBeanDAO implements UserInfoBeanDAO {
    private static final Logger LOG = Logger.getLogger(MySqlUserInfoBeanDAO.class);


    private static final String SQL_GET_USER_INFO_BEANS = "SELECT u.id, u.email, u.password, "
            + "i.first_name, i.last_name, i.passport_number, i.phone_number, "
            + "u.status FROM user u, user_info i WHERE i.user_id=u.id;";

    public UserInfoBean extractUserInfoBean(ResultSet rs) throws SQLException {
        UserInfoBean bean = new UserInfoBean();
        bean.setId(rs.getInt(Fields.USER_INFO_BEAN_USER_ID));
        bean.setLogin(rs.getString(Fields.USER_INFO_BEAN_EMAIL));
        bean.setPassword(rs.getString(Fields.USER_INFO_BEAN_PASSWORD));
        bean.setFirstName(rs.getString(Fields.USER_INFO_BEAN_FIRST_NAME));
        bean.setLastName(rs.getString(Fields.USER_INFO_BEAN_LAST_NAME));
        bean.setPassportNumber(rs
                .getString(Fields.USER_INFO_BEAN_PASSPORT_NUMBER));
        bean.setPhoneNumber(rs.getString(Fields.USER_INFO_BEAN_PHONE_NUMBER));
        bean.setEmail(rs.getString(Fields.USER_INFO_BEAN_EMAIL));
        bean.setStatus(rs.getBoolean(Fields.USER_INFO_BEAN_STATUS));
        return bean;
    }

    public List<UserInfoBean> getUserInfoBeans() throws DBException {
        List<UserInfoBean> infoUserBeanList = new ArrayList<UserInfoBean>();

        try (Connection con = DBManager.getInstance().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_GET_USER_INFO_BEANS)){

            while (rs.next()) {
                infoUserBeanList.add(extractUserInfoBean(rs));
            }
            /*con.commit();*/
        } catch (SQLException ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_INFO_BEANS, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_INFO_BEANS,
                    ex);
        } finally {
        }
        return infoUserBeanList;
    }
}
