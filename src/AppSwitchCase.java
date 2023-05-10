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
    
    public static void positivenumber(int a) throws ArithmeticException {

        if (a < 0) {
            System.out.println(a);
            throw new ArithmeticException("this value negative");
        }
    }
    public static void main(String[] args) throws Exception {
        ContactIMPL contactIMPL = new ContactIMPL();
        System.out.println("Welcome to the contact manager");
        Scanner scanner = new Scanner(System.in);
        ////adding default contacts
        Contact c1=new Contact(1, "nurgun", "22");
        Contact c2 = new Contact(2, "ulker", "2");
        Contact c3 = new Contact(3, "gulnar", "16");
        contactIMPL.addContact(c1);
        contactIMPL.addContact(c2);
        contactIMPL.addContact(c3);

        
        boolean operation = true;
        while (operation) {
            
            System.out.println(
                    "1 - add, 2 - show, 3 - edit, 4 - delete, 5 - exit, 6 - getbyname, 7-getbyid, 8- getbynumber");
            int value;
            try {
                value = scanner.nextInt();
                positivenumber(value);
               
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
                continue; // Restart the loop
            }
            catch(ArithmeticException a){
                System.out.println("this number is negative");
                continue;
            }

            switch (value) {
                case 1: {
                    clearConsole();
                    // System.out.print("\033[H\033[2J");
                    // System.out.flush();
                    System.out.println("add contact");
                    Contact c = new Contact();
                    System.out.println("id");

                    //// if id should be positive number
                    int id;
                    try {
                        id = scanner.nextInt();
                        positivenumber(id);
                        c.setId(id);
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("id must be a number");
                        continue;
                    }
                    catch (ArithmeticException a) {
                        System.out.println("enter positive number");
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
                        positivenumber(idtoedit);

                    } catch (InputMismatchException e) {
                        System.out.println("Enter a number.");
                        scanner.nextLine(); // Clear the input buffer
                        continue; // Restart the loop
                    }
                    catch (ArithmeticException a) {
                        System.out.println("this number is negative");
                        continue;
                    }
                    if (contactIMPL.checkexist(idtoedit)) {
                        Setnewid:
                        System.out.println("new id you want to set");
                        int newid;
                        try {
                            
                            newid = scanner.nextInt();
                            positivenumber(newid);
                            
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a number");
                            scanner.nextLine();
                            
                            continue;
                        }
                        catch (ArithmeticException a) {
                            System.out.println("this number is negative");
                            
                            continue;
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
                    int idDelete ;
                    try {
                        idDelete = scanner.nextInt();
                        positivenumber(idDelete);
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
                    catch (ArithmeticException a) {
                        System.out.println("this number is negative");
                        continue;
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
                    int finder;
                    try {
                        finder = scanner.nextInt();
                        positivenumber(finder);
                        System.out.println(contactIMPL.getbyId(finder));
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid integer.");
                        scanner.nextLine(); // Clear the input buffer
                        continue; // Restart the loop
                    }
                    catch (ArithmeticException a) {
                        System.out.println("this number is negative");
                        continue;
                    }
                    
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
    }
}