
import db.DBManager;
import db.dao.DaoFactory;
import db.entities.*;
import db.exceptions.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws DBException {


        int userId = 2;

        System.out.println(DaoFactory.getCarDaoInstance().findCarById(1).getModel());


    }
}
