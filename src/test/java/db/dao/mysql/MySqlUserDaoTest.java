package db.dao.mysql;

import db.DBManager;
import db.dao.DaoFactory;
import db.dao.UserDAO;
import db.entities.User;
import db.exceptions.DBException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MySqlUserDaoTest {
    @Test
    public void testAddUser() throws DBException {

        UserDAO userDao = DaoFactory.getUserDaoInstance();

        User user = new User();
        user.setRoleId(0);
        user.setEmail("test@mail.ua");
        user.setPassword("test");

        User actual = userDao.addUser(user);
        User expected = user;
        assertEquals(expected, actual);
    }
}
