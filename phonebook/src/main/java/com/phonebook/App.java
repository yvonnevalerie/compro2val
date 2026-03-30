package com.phonebook;

import java.util.Scanner;

import com.phonebook.models.Contact;
import com.phonebook.services.PhonebookService;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PhonebookService service = new PhonebookService();
        String file = "contacts.csv";

        service.loadFromCSV(file);

        int choice;

        do {
            System.out.println("\nPHONEBOOK MENU");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. Display All");
            System.out.println("5. Save");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    service.addContact(new Contact(name, phone, email));
                    System.out.println("Added!");
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String search = sc.nextLine();

                    Contact c = service.searchContact(search);

                    if (c != null) {
                        System.out.println("Found: " +
                                c.getName() + " | " +
                                c.getPhoneNumber() + " | " +
                                c.getEmail());
                    } else {
                        System.out.println("Not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to remove: ");
                    String remove = sc.nextLine();

                    service.removeContact(remove);
                    System.out.println("Removed.");
                    break;

                case 4:
                    service.displayAll();
                    break;

                case 5:
                    service.saveToCSV(file);
                    break;

                case 0:
                    service.saveToCSV(file);
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid.");
            }

        } while (choice != 0);

        sc.close();
    }
}
