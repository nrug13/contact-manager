// import java.util.InputMismatchException;
// import java.util.List;
// import java.util.Scanner;

// import entity.Contact;
// import impl.ContactIMPL;

// public class App {
// public static void main(String[] args) throws Exception {
// ContactIMPL contactIMPL = new ContactIMPL();
// System.out.println("Welcome to the contact manager");
// Scanner scanner = new Scanner(System.in);
// boolean operation = true;
// while (operation) {
// System.out.println("1 - add , 2 - show, 3- edit , 4- delete, 5- exit,
// 6-getbyname");
// // int value = scanner.nextInt();
// // System.out.println("value" + value);
// int value;
// try {
// value = scanner.nextInt();
// } catch (InputMismatchException e) {
// System.out.println(" Please enter a valid integer.");
// scanner.nextLine(); // Clear the input buffer
// continue; // Restart the loop
// }

// if (value == 1) {/// isleyir
// System.out.println("add contact");
// Contact c = new Contact();
// System.out.println("id");
// try {
// c.setId(scanner.nextInt());
// scanner.nextLine();
// } catch (InputMismatchException e) {
// System.out.println("id must be a number");
// continue;
// }
// System.out.println("name");
// c.setName(scanner.nextLine());
// // scanner.nextLine();
// System.out.println("number");
// c.setNumber(scanner.nextLine());

// contactIMPL.addContact(c);

// System.out.println(c);
// } else if (value == 2) {/// isleyir
// System.out.println("showing contacts");

// List<Contact> showList = contactIMPL.showContactList();

// for (Contact contact : showList) {
// System.out.println(contact.toString());

// }
// if (showList.size() == 0) {
// System.out.println("list is empty");
// }
// } else if (value == 3) {
// System.out.println(
// "edit contact: enter id,name,number.if id is correct you can edit. insert in
// multiple lines, not one");
// System.out.println("enter according to this order : ");
// System.out.println("id you want to edit");
// int idtoedit;
// try {
// idtoedit = scanner.nextInt();
// } catch (InputMismatchException e) {
// System.out.println("enter number.");
// scanner.nextLine(); // Clear the input buffer
// continue; // Restart the loop
// }

// System.out.println("new id you want to set");
// int newid;
// try {
// newid = scanner.nextInt();
// } catch (InputMismatchException e) {
// System.out.println("enter number");
// scanner.nextLine(); // Clear the input buffer
// continue; // Restart the loop
// }
// scanner.nextLine();
// System.out.println("new name");
// String newname=scanner.nextLine();
// scanner.nextLine();
// System.out.println("new number");
// String newnumber=scanner.nextLine();
// scanner.nextLine();
// System.out.println(contactIMPL.editContactbyID(
// idtoedit, newid,
// newname,
// newnumber));

// } else if (value == 4) {
// System.out.println("insert id");
// try {
// int idDelete = scanner.nextInt();
// contactIMPL.deleteContactbyID(idDelete);
// } catch (InputMismatchException e) {
// System.out.println("Invalid input. Please enter a valid integer for the
// ID.");
// scanner.nextLine(); // Clear the input buffer
// continue; // Restart the loop
// }

// } else if (value == 5) {// isleyir
// operation = false;
// } else if (value == 6) {

// System.out.println("enter name");
// scanner.nextLine();
// String finder = scanner.nextLine();
// System.out.println(contactIMPL.getContactbyName(finder));

// } else {// isleyir
// System.out.println("not any case");
// }
// }

// }

// }
