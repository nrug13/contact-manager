import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entity.Contact;
import impl.ContactIMPL;

public class AppSwitchCase {
    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exception if unable to clear console
        }
    }

    public static void main(String[] args) throws Exception {
        ContactIMPL contactIMPL = new ContactIMPL();
        System.out.println("Welcome to the contact manager");
        Scanner scanner = new Scanner(System.in);

        boolean operation = true;
        while (operation) {
            System.out.println("1 - add, 2 - show, 3 - edit, 4 - delete, 5 - exit, 6 - getbyname");
            int value;
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
                continue; // Restart the loop
            }

            switch (value) {
                case 1: {
                    clearConsole();
                    // System.out.print("\033[H\033[2J");
                    // System.out.flush();
                    System.out.println("add contact");
                    Contact c = new Contact();
                    System.out.println("id");
                    try {
                        c.setId(scanner.nextInt());
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("id must be a number");
                        continue;
                    }
                    System.out.println("name");
                    c.setName(scanner.nextLine());
                    System.out.println("number");
                    c.setNumber(scanner.nextLine());

                    contactIMPL.addContact(c);

                    System.out.println(c);
                    break;

                }
                case 2: {
                    clearConsole();
                    System.out.println("showing contacts");

                    List<Contact> showList = contactIMPL.showContactList();

                    for (Contact contact : showList) {
                        System.out.println(contact.toString());
                    }

                    if (showList.size() == 0) {
                        System.out.println("list is empty");
                    }
                    break;
                }
                case 3: {
                    clearConsole();
                    System.out.println(
                            "edit contact: enter id, name, number. If id is correct, you can edit. Insert in multiple lines, not one");
                    System.out.println("Enter according to this order:");
                    System.out.println("id you want to edit");
                    int idtoedit;

                    try {
                        idtoedit = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a number.");
                        scanner.nextLine(); // Clear the input buffer
                        continue; // Restart the loop
                    }
                    if (contactIMPL.checkexist(idtoedit)) {
                        System.out.println("new id you want to set");
                        int newid;
                        try {
                            newid = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a number");
                            scanner.nextLine(); // Clear the input buffer
                            continue; // Restart the loop
                        }
                        scanner.nextLine();
                        System.out.println("new name");
                        String newname = scanner.nextLine();
                        System.out.println("new number");
                        String newnumber = scanner.nextLine();

                        System.out.println(contactIMPL.editContactbyID(idtoedit, newid, newname, newnumber));
                    } else {
                        System.out.println("this id does not exist");
                    }

                    break;
                }
                case 4: {
                    clearConsole();
                    System.out.println("insert id");
                    try {
                        int idDelete = scanner.nextInt();
                        if (contactIMPL.checkexist(idDelete)) {
                            contactIMPL.deleteContactbyID(idDelete);
                        } else {
                            System.out.println("no such id");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for the ID.");
                        scanner.nextLine(); // Clear the input buffer
                        continue; // Restart the loop
                    }
                    break;
                }
                case 5: {
                    clearConsole();
                    operation = false;
                    break;
                }
                case 6: {
                    clearConsole();
                    System.out.println("enter name");
                    scanner.nextLine();
                    String finder = scanner.nextLine();
                    System.out.println(contactIMPL.getContactbyName(finder));
                    break;

                }
                default:
                    System.out.println("no case");
                    break;
            }
        }
    }
}