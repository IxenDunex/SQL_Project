package org.example;

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
public void delete(DatabaseConnection dbc, Integer id_record) {
    String insert = "delete from person WHERE id =" + id_record;
    dbc.executeInsert(insert);
}

}
