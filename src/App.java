import java.util.List;
import java.util.Scanner;

import entity.Contact;
import impl.ContactIMPL;

public class App {
    public static void main(String[] args) throws Exception {
        ContactIMPL contactIMPL = new ContactIMPL();
        System.out.println("Welcome to the contact manager");
        Scanner scanner = new Scanner(System.in);
        boolean operation = true;
        while (operation) {
            System.out.println("1 - add , 2 - show, 3- edit , 4- delete, 5- exit, 6-getbyname");
            int value = scanner.nextInt();
            // System.out.println("value" + value);

            if (value == 1) {/// isleyir
                System.out.println("add contact");
                Contact c = new Contact();
                System.out.println("id");
                c.setId(scanner.nextInt());
                scanner.nextLine();
                System.out.println("name");
                c.setName(scanner.nextLine());
                // scanner.nextLine();
                System.out.println("number");
                c.setNumber(scanner.nextLine());

                contactIMPL.addContact(c);

                System.out.println(c);
            } else if (value == 2) {/// isleyir
                System.out.println("show contacts");

                List<Contact> showList = contactIMPL.showContactList();

                for (Contact contact : showList) {
                    System.out.println(contact.toString());

                }
            } else if (value == 3) {
                System.out.println(
                        "edit contact: enter id,name,number.if id is correct you can edit. insert in multiple lines, not one");
                System.out.println("enter according to this order : ");
                System.out.println("id you want to edit");
                System.out.println("new id you want to set");
                System.out.println("new name");
                System.out.println("new number");
                System.out.println(contactIMPL.editContactbyID(scanner.nextInt(), scanner.nextInt(),
                        scanner.nextLine(),
                        scanner.nextLine()));

            } else if (value == 4) {
                System.out.println("insert id");
                int idDelete = scanner.nextInt();
                contactIMPL.deleteContactbyID(idDelete);

                // List<Contact> showList = contactIMPL.showContactList();

                // for (Contact contact : showList) {
                //     System.out.println(contact.toString());

                // }
            } else if (value == 5) {// isleyir
                operation = false;
            } else if (value == 6) {
                
                System.out.println("enter name");
                contactIMPL.getContactbyName(scanner.nextLine());

            } else {//isleyir
                System.out.println("not any case");
            }
        }

    }

}
