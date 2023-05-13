import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import entity.Contact;
import impl.ContactIMPL;
import java.util.Random;

public class AppSwitchCase {
    //// bu hisse console-daki tarixceni silmek ucundur
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

    public static void menu() {
        System.out.println(
                "1 - add, 2 - show, 3 - edit, 4 - delete, 5 - exit, 6 - getbyname, 7-getbyid, 8- getbynumber");
    }

    ////////////////// bu hisse menfi eded olanda exception ucundur
    public static void positivenumber(int a) throws ArithmeticException {

        if (a < 0) {
            System.out.println(a);
            throw new ArithmeticException("this value negative");
        }
    }

    private static int checkNumber(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                positivenumber(value);
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
            } catch (ArithmeticException a) {
                System.out.println("This number is negative");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        clearConsole();
        ContactIMPL contactIMPL = new ContactIMPL();
        System.out.println("Welcome to the contact manager");
        Scanner scanner = new Scanner(System.in);
        // adding default contacts
        // Contact c1 = new Contact(1, "nurgun", "22");
        // Contact c2 = new Contact(2, "ulker", "2");
        // Contact c3 = new Contact(3, "gulnar", "16");
        // contactIMPL.addContact(c1);
        // contactIMPL.addContact(c2);
        // contactIMPL.addContact(c3);
        contactIMPL.createRandomContacts(4);

        boolean operation = true;
        while (operation) {

            menu();

            int value = checkNumber(scanner);

            switch (value) {

                case 1: {
                    clearConsole();
                    System.out.println("add contact");
                    Contact c = new Contact();
                    System.out.println("id");
                    //// if id should be positive number
                    int id = checkNumber(scanner);

                    if (!contactIMPL.checkexist(id)) {
                        System.out.println("name");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        c.setName(name);
                        System.out.println("number");
                        String number = scanner.nextLine();
                        c.setNumber(number);
                        c.setId(id);
                        contactIMPL.addContact(c);
                        System.out.println(c);
                    } else {
                        System.out.println("this id exists");
                    }
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
                    int idtoedit = checkNumber(scanner);
                    

                    // try {

                    // idtoedit = scanner.nextInt();
                    // positivenumber(idtoedit);

                    // } catch (InputMismatchException e) {
                    // System.out.println("Enter a number.");
                    // scanner.nextLine(); // Clear the input buffer
                    // continue; // Restart the loop
                    // } catch (ArithmeticException a) {
                    // System.out.println("this number is negative");
                    // continue;
                    // }
                    if (contactIMPL.checkexist(idtoedit)) {

                        System.out.println("new id you want to set");
                        int newid = checkNumber(scanner);
                        // try {

                        // newid = scanner.nextInt();
                        // positivenumber(newid);

                        // } catch (InputMismatchException e) {
                        // System.out.println("Enter a number");
                        // scanner.nextLine();

                        // continue;
                        // } catch (ArithmeticException a) {
                        // System.out.println("this number is negative");

                        // continue;
                        // }
                        scanner.nextLine();
                        if (!contactIMPL.checkexist(newid)) {
                            System.out.println("new name");
                            String newname = scanner.nextLine();
                            System.out.println("new number");
                            String newnumber = scanner.nextLine();

                            System.out.println(contactIMPL.editContactbyID(idtoedit, newid, newname, newnumber));
                        } else {
                            System.out.println("this id exists");
                        }
                    } else {
                        System.out.println("this id does not exist");
                    }

                    break;
                }
                case 4: {
                    clearConsole();
                    System.out.println("insert id");
                    int idDelete = checkNumber(scanner);
                    // int idDelete;
                    // try {
                    // idDelete = scanner.nextInt();
                    // positivenumber(idDelete);
                    // if (contactIMPL.checkexist(idDelete)) {
                    // contactIMPL.deleteContactbyID(idDelete);
                    // } else {
                    // System.out.println("no such id");
                    // }

                    // } catch (InputMismatchException e) {
                    // System.out.println("Invalid input. Please enter a valid integer for the
                    // ID.");
                    // scanner.nextLine(); // Clear the input buffer
                    // continue; // Restart the loop
                    // } catch (ArithmeticException a) {
                    // System.out.println("this number is negative");
                    // continue;
                    // }

                    if (contactIMPL.checkexist(idDelete)) {
                        contactIMPL.deleteContactbyID(idDelete);
                    } else {
                        System.out.println("no such id");
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

                case 7: {
                    clearConsole();
                    System.out.println("enter id");
                    scanner.nextLine();
                    // int finder;
                    // try {
                    //     finder = scanner.nextInt();
                    //     positivenumber(finder);
                    //     System.out.println(contactIMPL.getbyId(finder));
                    // } catch (InputMismatchException e) {
                    //     System.out.println("Please enter a valid integer.");
                    //     scanner.nextLine(); // Clear the input buffer
                    //     continue; // Restart the loop
                    // } catch (ArithmeticException a) {
                    //     System.out.println("this number is negative");
                    //     continue;
                    // }
                    int finder = checkNumber(scanner);

                    System.out.println(contactIMPL.getbyId(finder));
                    break;
                }
                case 8: {
                    clearConsole();
                    System.out.println("enter number");
                    scanner.nextLine();
                    String finder = scanner.nextLine();
                    System.out.println(contactIMPL.getbyNumber(finder));

                    break;

                }
                default:
                    System.out.println("no case");
                    break;
            }

        }
        clearConsole();
    }
}