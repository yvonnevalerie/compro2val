package com.phonebook.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.phonebook.models.Contact;

public class PhonebookService {

    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact c) {
        contacts.put(c.getName(), c);
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact c : contacts.values()) {
            System.out.println(c.getName() + " | " +
                    c.getPhoneNumber() + " | " +
                    c.getEmail());
        }
    }

    public void saveToCSV(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (Contact c : contacts.values()) {
                writer.write(c.toCsvString());
                writer.newLine();
            }

            System.out.println("Saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void loadFromCSV(String filename) {
        File file = new File(filename);

        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) {
                    Contact c = new Contact(data[0], data[1], data[2]);
                    contacts.put(c.getName(), c);
                }
            }

            System.out.println("Contacts loaded.");

        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}
