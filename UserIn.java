// Write a Java program which will demonstrate a concept of cohesion
// and coupling of the various modules in the program.

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


// Module 1: User Interface (High Cohesion)
class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        // Display the menu options
        System.out.println("1. Add new contact");
        System.out.println("2. Search contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Exit");
    }

    public int getInput() {
        // Get user input for menu selection
        return scanner.nextInt();
    }

    public String getInput(String prompt) {
        // Get user input with a prompt
        System.out.print(prompt);
        return scanner.next();
    }

    public void displayContactDetails(String name, String phoneNumber) {
        // Display contact details
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
    }
}

// Module 2: Contact Manager (High Cohesion)
class ContactManager {
    // Dummy contact list for demonstration
    private Map<String, String> contacts;

    public ContactManager() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Adding contact: " + name + ", Phone: " + phoneNumber);
    }

    public String searchContact(String name) {
        String phoneNumber = contacts.get(name);
        if (phoneNumber != null) {
            return phoneNumber;
        } else {
            System.out.println("Contact not found.");
            return null; // Contact not found
        }
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Deleting contact: " + name);
        } else {
            System.out.println("Contact not found.");
        }
    }
}


// Main Program (Low Coupling)
public class UserIn {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ContactManager contactManager = new ContactManager();
    
        while (true) {
            // Display menu and get user input
            ui.displayMenu();
            int choice = ui.getInput();
    
            // Process user input
            switch (choice) {
                case 1:
                    // Add new contact
                    String newName = ui.getInput("Enter name: ");
                    String newPhoneNumber = ui.getInput("Enter phone number: ");
                    contactManager.addContact(newName, newPhoneNumber);
                    break;
                case 2:
                    // Search contact
                    String searchName = ui.getInput("Enter name to search: ");
                    String phoneNumber = contactManager.searchContact(searchName);
                    ui.displayContactDetails(searchName, phoneNumber);
                    break;
                case 3:
                    // Delete contact
                    String deleteName = ui.getInput("Enter name to delete: ");
                    contactManager.deleteContact(deleteName);
                    break;
                case 4:
                    // Exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}    