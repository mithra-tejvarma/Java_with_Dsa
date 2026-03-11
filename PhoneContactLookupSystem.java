import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Contact {
    String name;
    String email;

    Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    void display(String phone) {
        System.out.println("Phone : " + phone);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}

public class PhoneContactLookupSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Contact> contacts = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== PHONE CONTACT LOOKUP SYSTEM =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact by Phone");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    if (contacts.containsKey(phone)) {
                        System.out.println("Contact already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    contacts.put(phone, new Contact(name, email));
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Phone Number to search: ");
                    String searchPhone = sc.nextLine();

                    if (contacts.containsKey(searchPhone)) {
                        System.out.println("\nContact Found:");
                        contacts.get(searchPhone).display(searchPhone);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Phone Number to delete: ");
                    String deletePhone = sc.nextLine();

                    if (contacts.remove(deletePhone) != null) {
                        System.out.println("Contact deleted successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts available.");
                    } else {
                        System.out.println("\n===== ALL CONTACTS =====");
                        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                            entry.getValue().display(entry.getKey());
                            System.out.println("------------------------");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}