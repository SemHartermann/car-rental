package db.dao.mysql;

import db.DBManager;
import db.dao.DaoFactory;
import db.dao.UserInfoDAO;
import db.entities.UserInfo;
import db.exceptions.DBException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MySqlUserInfoDaoTest {
    @Test
    public void testAddUserInfo() throws DBException {
        UserInfoDAO userInfoDao = DaoFactory.getUserInfoDAOInstance();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1);
        userInfo.setFirstName("Simon");
        userInfo.setLastName("Hartermann");
        userInfo.setPassportNumber("MB562321");
        userInfo.setPhoneNumber("0506975063");
        userInfo.setEmail("semzhivotov@gmail.com");

        UserInfo actual = userInfoDao.addUserInfo(userInfo);
        UserInfo expected = userInfo;
        assertEquals(expected, actual);
    }
}
