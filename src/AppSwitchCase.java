import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import entity.Contact;
import impl.ContactIMPL;
import inter.ContactInterface;
import java.util.Random;

public class AppSwitchCase {

    public static void main(String[] args) throws Exception {
        ContactInterface.clearConsole();
        ContactIMPL contactIMPL = new ContactIMPL();
        System.out.println("Welcome to the contact manager");
        Scanner scanner = new Scanner(System.in);
        boolean operation = true;
        while (operation) {

            System.out.println("1 - add");
            System.out.println("2 - show");
            System.out.println("3 - edit");
            System.out.println("4 - delete");
            System.out.println("5 - exit");
            System.out.println("6 - get by name");
            System.out.println("7 - get by id");
            System.out.println("8 - get by number");
            System.out.println("9 - generate random contacts");

            int value = ContactInterface.checkNumber(scanner);

            switch (value) {

                case 1: {
                    // clearConsole();
                    ContactInterface.clearConsole();
                    System.out.println("add contact");
                    Contact c = new Contact();
                    System.out.println("id");

                    int id = ContactInterface.checkNumber(scanner);

                    if (!contactIMPL.checkexist(id)) {
                        System.out.println("name");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        c.setName(name);
                        System.out.print("number: +994 ");
                        String number = scanner.next();
                        try {
                            if (contactIMPL.phoneNumberLength(number)) {

                                c.setNumber(number);
                                c.setId(id);
                                contactIMPL.addContact(c);
                                System.out.println(c);
                            }
                        } catch (ArithmeticException e) {
                            System.out.println(e);
                        }

                    } else {
                        System.out.println("this already exists");
                    }
                    break;

                }
                case 2: {
                    ContactInterface.clearConsole();
                    System.out.println("showing contacts");
                    contactIMPL.showContactList();
                    break;
                }
                case 3: {
                    ContactInterface.clearConsole();
                    System.out.println(
                            "edt");
                    System.out.println("Enter according to this order:");
                    System.out.println("id you want to edit");
                    int idtoedit = ContactInterface.checkNumber(scanner);

                    if (contactIMPL.checkexist(idtoedit)) {

                        System.out.println("new id you want to set");
                        int newid = ContactInterface.checkNumber(scanner);
                        scanner.nextLine();
                        System.out.println("new name");
                        String newname = scanner.nextLine();
                        System.out.println("new number");
                        String newnumber = scanner.nextLine();
                        try {
                            if (contactIMPL.phoneNumberLength(newnumber)) {
                                contactIMPL.editContactbyID(idtoedit, newid, newname, newnumber);
                            }
                        } catch (Exception e) {
                            System.out.println(e);

                        }
                    }

                    break;
                }
                case 4: {
                    ContactInterface.clearConsole();
                    System.out.println("insert id");
                    int idDelete = ContactInterface.checkNumber(scanner);
                    contactIMPL.deleteContactbyID(idDelete);

                    break;
                }
                case 5: {
                    ContactInterface.clearConsole();
                    operation = false;
                    ContactInterface.clearConsole();
                    break;

                }
                case 6: {
                    ContactInterface.clearConsole();
                    System.out.println("enter name");
                    scanner.nextLine();
                    String finder = scanner.nextLine();
                    System.out.println(contactIMPL.getContactbyName(finder));
                    break;

                }
                case 7: {
                    ContactInterface.clearConsole();
                    System.out.println("enter id");
                    scanner.nextLine();
                    int finder = ContactInterface.checkNumber(scanner);
                    System.out.println(contactIMPL.getbyId(finder));

                    break;
                }
                case 8: {
                    ContactInterface.clearConsole();
                    System.out.println("enter number");
                    scanner.nextLine();
                    String finder = scanner.nextLine();
                    System.out.println(contactIMPL.getbyNumber(finder));
                    break;
                }
                case 9: {
                    System.out.println("generating random contacts, add number of contact");
                    int people = scanner.nextInt();
                    contactIMPL.createRandomContacts(people);
                    System.out.println(contactIMPL.showContactList());

                }
                default:
                    System.out.println("no case");
                    break;
            }

        }
        ContactInterface.clearConsole();
    }

}