package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {
    String username;
    String email;
    String pass;
    Boolean enabled;
    Integer id;

    public Person(String username, String email, String pass, Boolean enabled, Integer id) {
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.enabled = enabled;
        this.id = id;
    }


    public void create(DatabaseConnection dbc) {
        String insert = "Insert into person values ('" +
                this.username + "', '" +
                this.email + "', '" +
                this.pass + "', " +
                this.enabled.toString() + ", " +
                this.id + ")";
        dbc.executeInsert(insert);
    }

    public void delete(DatabaseConnection dbc) {
        String sql = "DELETE FROM person WHERE username = '" + this.username + "'";
        int count = dbc.executeDelete(sql);
        System.out.println("Usunięto " + count + " rekordów.");
    }

}
