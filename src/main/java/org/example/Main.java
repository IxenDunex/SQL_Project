package org.example;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.connect();
        boolean quit = false;

        while (!quit) {
            //EKRAN POWITALNY
            MenuQuestions();
            int option = scanner.nextInt();
            scanner.nextLine();  //nowy wiersz

            switch (option) {
                default:
                    throw new IllegalStateException("Nieprawidłowa opcja: " + option);
                case 1:
                    System.out.print("DODAWANIE NOWEGO REKORDU DO BAZY 'PERSON'\n");
                    System.out.print("Podaj USERNAME: ");
                    String new_username = scanner.nextLine();
                    System.out.print("Podaj EMAIL: ");
                    String new_email = scanner.nextLine();
                    System.out.print("Podaj PASSWORD: ");
                    String new_pass = scanner.nextLine();
                    System.out.print("REKORD AKTYWNY? (true/false): ");
                    boolean enabled = scanner.nextBoolean();
                    scanner.nextLine();
                    //Utworzenie nowego rekordu z klasy Person
                    Person new_user = new Person(new_username, new_email, new_pass, enabled, -1);
                    new_user.createRecord(dbc);
                    break;
                case 2:
                    System.out.print("ODCZYT REKORDU Z BAZY 'PERSON'\n");
                    System.out.print("Podaj nazwę użytkownika: ");
                    String read_user = scanner.nextLine();
                    Person my_user = new Person( read_user, "", "", false, 2);
                    my_user.readRecord(dbc);
                    break;
                case 3:
                    System.out.print("AKTUALIZACJA REKORDU W BAZIE 'PERSON'\n");
                    System.out.print("Podaj nazwę użytkownika: ");
                    String username_db = scanner.nextLine();
                    System.out.print("Zmień adres email: ");
                    String email2 = scanner.nextLine();
                    Person updated_user = new Person(username_db, email2, "",true,0);
                    updated_user.updateRecord(dbc);
                    break;
                case 4: System.out.print("USUWANIE REKORDU Z BAZY 'PERSON'\n");
                    System.out.print("Podaj USERNAME: ");
                    String search_name = scanner.nextLine();
                    Person delete_user = new Person(search_name, "", "", false,1);
                    delete_user.deleteRecord(dbc);
                    break;
                case 5:
                    System.out.print("KONIEC PROGRAMU");
                    quit = true;
                    break;

            }
        }
}


    private static void MenuQuestions() {
        System.out.println("\n****** WITAMY W BAZIE 'PERSON' ******\n");
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj nowy rekord do bazy");
        System.out.println("2. Odczytaj rekord z bazy");
        System.out.println("3. Aktualizuj rekord w bazie");
        System.out.println("4. Usuń rekord z bazy");
        System.out.println("5. EXIT");
        System.out.print("> ");
    }
}
