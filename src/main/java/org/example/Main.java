package org.example;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.connect();
        Person kazik = new Person("Kazik","em@@@@il", "BlaBla", false, 4 );
        kazik.save(dbc);

    }
}