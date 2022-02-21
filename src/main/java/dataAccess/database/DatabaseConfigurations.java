package dataAccess.database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConfigurations {
            private static Connection conn=null;
            private static Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);;


    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE,"Failed To Find Driver Class");
        }
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firm", "root", "root");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static void closeConnection(){
        try {
            if (conn == null || conn.isClosed()) {
                return;
            }else {
                conn.close();
            }
        } catch (SQLException throwable) {
            logger.log(Level.SEVERE,"Failed to close the connection");
        }
    }
}
