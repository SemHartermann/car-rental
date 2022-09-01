package db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static Logger LOG = Logger.getLogger(DBManager.class);
    private static final String URL = "jdbc:mysql://localhost:3306/car-rental";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Tya8KSMY";

    private static DBManager instance;

    // Singleton
    private DBManager() {}

    synchronized public static DBManager getInstance(){
        if(instance==null){
            instance = new DBManager();
        }
        return instance;
    }



    public Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (ClassNotFoundException e) {
            LOG.error("Driver not found");
            //throw new ClassNotFoundException(e);
            e.printStackTrace();
        } catch (SQLException e) {
            LOG.fatal("Unable to get connection");
            //throw new RuntimeException(e);
            throw new SQLException(e);
        }

        return con;
    }
}