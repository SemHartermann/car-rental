
import db.dao.DaoFactory;
import db.dao.mysql.MySqlOrderDAO;
import db.entities.*;
import db.exceptions.DBException;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws DBException {


        List<UserInfo> userInfoList = new ArrayList<>();

        MySqlOrderDAO order = DaoFactory.getOrderDaoInstance();


        System.out.println(order.findOrderById(32).isDamage());


    }
}
