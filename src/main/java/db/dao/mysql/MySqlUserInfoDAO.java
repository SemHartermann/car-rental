package db.dao.mysql;

import db.DBManager;
import db.Fields;
import db.dao.UserInfoDAO;
import db.entities.UserInfo;
import db.exceptions.DBException;
import db.exceptions.Messages;
import org.apache.log4j.Logger;

import java.sql.*;

public class MySqlUserInfoDAO implements UserInfoDAO {
    private static final Logger LOG = Logger.getLogger(MySqlUserInfoDAO.class);
    private static final String SQL_FIND_USER_INFO_BY_USER_ID = "SELECT * FROM user_info WHERE user_info.user_id=?";
    private static final String SQL_UPDATE_USER_INFO = "UPDATE user_info SET first_name=?, last_name=?, passport_number=?, phone_number=? WHERE id=?";
    private static final String SQL_CREATE_NEW_USER_INFO = "INSERT INTO user_info (user_id , first_name, last_name, passport_number, phone_number) VALUES (?, ?, ?, ?, ?)";

    public UserInfo findUserInfoByUserId(int id) throws DBException {
        UserInfo userInfo = null;


        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_USER_INFO_BY_USER_ID)){

            pstmt.setLong(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userInfo = extractUserInfo(rs);
            }

        } catch (SQLException ex) {
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_INFO_BY_ID, ex);
        } finally {

        }
        return userInfo;
    }

    public UserInfo addUserInfo(UserInfo u) throws DBException {
        UserInfo userInfo = u;
        try (Connection con = DBManager.getInstance().getConnection();
        PreparedStatement pstmt = con.prepareStatement(SQL_CREATE_NEW_USER_INFO);
        ResultSet rs = pstmt.executeQuery()){
            pstmt.setInt(1, userInfo.getUserId());
            pstmt.setString(2, userInfo.getFirstName());
            pstmt.setString(3, userInfo.getLastName());
            pstmt.setString(4, userInfo.getPassportNumber());
            pstmt.setString(5, userInfo.getPhoneNumber());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            LOG.error(Messages.ERR_CANNOT_CREATE_CAR, ex);
        } finally {

        }
        return userInfo;
    }

    public void updateUserInfo(UserInfo userInfo) throws DBException {
        try (Connection con = DBManager.getInstance().getConnection()){
            updateUserInfo(con, userInfo);

        } catch (SQLException ex) {

            throw new DBException(Messages.ERR_CANNOT_UPDATE_USER_INFO, ex);
        } finally {

        }
    }

    public void updateUserInfo(Connection con, UserInfo userInfo)
            throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(SQL_UPDATE_USER_INFO);
            int k = 1;
            pstmt.setString(k++, userInfo.getFirstName());
            pstmt.setString(k++, userInfo.getLastName());
            pstmt.setString(k++, userInfo.getPassportNumber());
            pstmt.setString(k++, userInfo.getPhoneNumber());
            pstmt.setInt(k, userInfo.getId());
            pstmt.executeUpdate();
        } finally {

        }
    }

    public UserInfo extractUserInfo(ResultSet rs) throws SQLException {
        UserInfo userinfo = new UserInfo();
        userinfo.setId(rs.getInt(Fields.ENTITY_ID));
        userinfo.setUserId(rs.getInt(Fields.USER_INFO_USER_ID));
        userinfo.setFirstName(rs.getString(Fields.USER_INFO_FIRST_NAME));
        userinfo.setLastName(rs.getString(Fields.USER_INFO_LAST_NAME));
        userinfo.setPassportNumber(rs.getString(Fields.USER_INFO_PASSPORT_NUMBER));
        userinfo.setPhoneNumber(rs.getString(Fields.USER_INFO_PHONE_NUMBER));
        userinfo.setEmail(rs.getString(Fields.USER_INFO_EMAIL));

        return userinfo;
    }

}
