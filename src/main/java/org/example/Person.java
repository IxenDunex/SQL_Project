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

    public void save(DatabaseConnection dbc) {
        String insert = "insert into person values (" + "'" + this.username + "','" + this.email + "','" + this.pass + "'," + this.enabled + ","+ this.id + ")";
        dbc.executeInsert(insert);
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

//    public void read(DatabaseConnection dbc) throws SQLException {
//        String sql = "SELECT * FROM person WHERE username = '" + this.username + "'";
//        ResultSet result = dbc.executeSelect(sql);
//        while (result.next()) {
//            String username = result.getString("username");
//            String email = result.getString("email");
//            String pass = result.getString("password");
//            boolean enabled = result.getBoolean("enabled");
//            int id = result.getInt("id");
//            Person p = new Person(username, email, pass, enabled, id);
//
//
//            // przetwarzanie pobranego rekordu obiektu z Bazy 'Person'
//            System.out.println("username: " + username + ", email: " + email + ", pass: " + pass + ", enabled: " + enabled + ", id: " + id );
//        }
//    }

}
