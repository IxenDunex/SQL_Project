package org.example;
import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection dbc = new DatabaseConnection();
        dbc.connect();
        boolean quit = false;

        //EKRAN POWITALNY
        while (!quit) {
            MenuQuestions();

            int option = scanner.nextInt();
            scanner.nextLine();  //nowy wiersz po wczytaniu int

            switch (option) {
                default:
                    throw new IllegalStateException("Nieprawidłowa opcja: " + option);
                case 1:
                    System.out.print("Podaj USERNAME: ");
                    String username = scanner.nextLine();
                    System.out.print("Podaj EMAIL: ");
                    String email = scanner.nextLine();
                    System.out.print("Podaj PASSWORD: ");
                    String pass = scanner.nextLine();
                    System.out.print("REKORD AKTYWNY? (true/false): ");
                    boolean enabled = scanner.nextBoolean();
                    scanner.nextLine();
                    //Utworzenie nowego rekordu z klasy Person
                    Person add_person = new Person(username, email, pass, enabled, -1);
                    add_person.create(dbc);
                    break;
                case 3:
                    System.out.print("Podaj nazwę użytkownika: ");
                    String username_db = scanner.nextLine();
                    System.out.print("Zmień adres email: ");
                    String email2 = scanner.nextLine();
                    Person PersonUpdated = new Person(username_db, email2, "",true,0);
                    PersonUpdated.update(dbc);
                    break;
                    case 4:
                    System.out.print("Podaj USERNAME: ");
                    String search_name = scanner.nextLine();
                    Person search_record = new Person(search_name, "", "", false,1);
                    search_record.delete(dbc);
                    break;
//
                case 5:
                    quit = true;
                    break;

            }
        }
}


    private static void MenuQuestions() {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj nowy rekord do bazy 'PERSON'");
        System.out.println("2. Odczytaj rekord z bazy 'PERSON'");
        System.out.println("3. Aktualizuj rekord w bazie 'PERSON'");
        System.out.println("4. Usuń rekord z bazy 'PERSON'");
        System.out.println("5. EXIT");
        System.out.print("> ");
    }
}
