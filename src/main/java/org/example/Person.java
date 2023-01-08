package org.example;

import java.sql.*;

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


    public void createRecord(DatabaseConnection dbc) {
        String sql_query = "Insert into person values ('" +
                this.username + "', '" +
                this.email + "', '" +
                this.pass + "', " +
                this.enabled.toString() + ", " +
                this.id + ")";
        dbc.executeCreate(sql_query);
    }

    public void readRecord(DatabaseConnection dbc) throws SQLException {
            String sql_query = "Select * FROM person WHERE username = '" + this.username + "'";
            ResultSet read_record = dbc.executeRead(sql_query);

            while (read_record.next()) {
                String read_username = read_record.getString("username");
                String read_email = read_record.getString("email");
                String read_pass = read_record.getString("password");
                boolean enabled = read_record.getBoolean("enabled");
                int id = read_record.getInt("id");
                Person read_Person = new Person(read_username, read_email,read_pass, enabled, id);
                System.out.println("\nID:\tUSERNAME:\tEMAIL:\t\t\t\tPASSWORD:\tENABLED:");
                System.out.println("\n" + id + "\t" + read_username
                        + "\t\t" + read_email+ "\t" + read_pass+ "\t\t" + enabled);
                System.out.println(">>> KONIEC ODCZYTU <<<\n");
            }
    }


    public void updateRecord(DatabaseConnection dbc) {
        String sql_query = "UPDATE person SET email = '" + this.email + "' WHERE username = '" + this.username + "'";
        int count = dbc.executeUpdate(sql_query);
        System.out.println("Zmodyfikowano " + count + " rekord w bazie 'PERSON'.");
    }

    public void deleteRecord(DatabaseConnection dbc) {
        String sql_query = "DELETE FROM person WHERE username = '" + this.username + "'";
        int count = dbc.executeDelete(sql_query);
        System.out.println("Usunięto " + count + " rekord w bazie 'PERSON'.");
    }

}