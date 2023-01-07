package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static final String Host = "jdbc:postgresql://snuffleupagus.db.elephantsql.com/hduydxwm";
    public static final String USERNAME = "hduydxwm";
    public static final String PASS = "HfE3FtXdZRNC4c_5fbKZYmE0BY0NM2fi";

    public Connection connection;
    public void connect() {

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(Host, USERNAME, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void executeInsert(String sql){
        Statement stm = null;
        try {
            stm = this.connection.createStatement();
            stm.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
