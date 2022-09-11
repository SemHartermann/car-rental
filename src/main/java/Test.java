
import db.DBManager;
import db.dao.DaoFactory;
import db.entities.*;
import db.exceptions.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws DBException {


        List<UserInfo> userInfoList = new ArrayList<>();

        userInfoList.clear();

        System.out.println(userInfoList.size());


    }
}
