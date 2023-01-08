package org.example;
import java.sql.*;

public class DatabaseConnection {
    public static final String Host = "jdbc:postgresql://snuffleupagus.db.elephantsql.com/hduydxwm";
    public static final String USERNAME = "hduydxwm";
    public static final String PASS = "HfE3FtXdZRNC4c_5fbKZYmE0BY0NM2fi";

    public Connection connection;
    Statement stm = null;
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

    //CREATE
    public void executeCreate(String sql){

        try {
            stm = this.connection.createStatement();
            stm.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // UPDATE
    public int executeUpdate(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Delete
    public int executeDelete(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Read
    public ResultSet executeRead(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            return stm.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
