package db.dao;

import db.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface UserDAO {
    public List<User> findUsers();
    public User findUserById(int id);

    public User findUserByLogin(String login);
    public User addUser(User u);
    public void updateUserStatus(User user);
    public void updateUserStatus(Connection con, User user);
    public User extractUser(ResultSet rs);

}
