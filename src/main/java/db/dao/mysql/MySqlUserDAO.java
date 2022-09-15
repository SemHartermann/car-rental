package db.dao.mysql;


import db.DBManager;
import db.Fields;
import db.dao.UserDAO;
import db.entities.User;
import db.exceptions.DBException;
import db.exceptions.Messages;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlUserDAO implements UserDAO {

    private static final Logger LOG = Logger.getLogger(MySqlUserDAO.class);

    private static final String SQL_UPDATE_USER = "UPDATE user SET status=? WHERE id=?";
    private static final String SQL_FIND_ALL_USERS = "SELECT * FROM user";
    private static final String SQL_FIND_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM user WHERE email=?";

    private static final String SQL_CREATE_NEW_USER = "INSERT INTO user (role_id , email, password) VALUES (?, ?, ?)";
    public List<User> findUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection con = DBManager.getInstance().getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_USERS)) {

            while (rs.next()) {
                userList.add(extractUser(rs));
            }

        } catch (SQLException ex) {

            LOG.error(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
            /*throw new DBException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);*/
            ex.printStackTrace();
        } finally {


        }
        return userList;
    }

    public User findUserById(int id) {
        User user = null;
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_USER_BY_ID)) {

            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
            con.commit();
        } catch (SQLException ex) {

            /*throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_BY_ID, ex);*/
            ex.printStackTrace();
        } finally {
        }
        return user;
    }

    public User findUserByLogin(String login) {
        User user = null;
        LOG.info(login);
        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);){
            pstmt.setString(1, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
            con.commit();
        } catch (SQLException ex) {

            /*throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN, ex);*/
            ex.printStackTrace();
        } finally {

        }
        return user;
    }

    public User addUser(User u) {
        User user = u;

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(SQL_CREATE_NEW_USER);){

            pstmt.setInt(1, user.getRoleId()+1);
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException ex) {

            LOG.error(Messages.ERR_CANNOT_CREATE_USER, ex);
            ex.printStackTrace();
        } finally {

        }
        return user;
    }

    public void updateUserStatus(User user){

        try (Connection con = DBManager.getInstance().getConnection()){
            updateUserStatus(con, user);
            con.commit();
        } catch (SQLException ex) {

            /*throw new DBException(Messages.ERR_CANNOT_UPDATE_USER, ex);*/
            ex.printStackTrace();
        } finally {
        }
    }

    public void updateUserStatus(Connection con, User user){
        try (PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_USER)){
            pstmt.setBoolean(1, user.isStatus());
            pstmt.setInt(2, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public User extractUser(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getInt(Fields.ENTITY_ID));
            user.setRoleId(rs.getInt(Fields.USER_ROLE_ID)-1);
            user.setEmail(rs.getString(Fields.USER_LOGIN));
            user.setPassword(rs.getString(Fields.USER_PASSWORD));
            user.setStatus(rs.getBoolean(Fields.USER_STATUS));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


}
