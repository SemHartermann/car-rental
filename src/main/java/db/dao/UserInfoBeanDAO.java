package db.dao;

import db.entities.UserInfoBean;
import db.exceptions.DBException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserInfoBeanDAO {
    public UserInfoBean extractUserInfoBean(ResultSet rs) throws SQLException;
    public List<UserInfoBean> getUserInfoBeans() throws DBException;
}
