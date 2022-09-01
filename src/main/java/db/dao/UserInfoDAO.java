package db.dao;

import db.entities.UserInfo;
import db.exceptions.DBException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserInfoDAO {
    public UserInfo findUserInfoByUserId(int id)  throws DBException;
    public UserInfo addUserInfo(UserInfo u) throws DBException;
    public void updateUserInfo(UserInfo userInfo) throws DBException;
    public void updateUserInfo(Connection con, UserInfo userInfo) throws SQLException;
    public UserInfo extractUserInfo(ResultSet rs) throws SQLException;
}
