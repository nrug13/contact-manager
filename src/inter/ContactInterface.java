package inter;

import java.rmi.NoSuchObjectException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entity.*;

public interface ContactInterface {
    public void addContact(Contact c);

    List<Contact> showContactList();

    public List<Contact> getContactbyName(String name);

    public List<Contact> deleteContactbyID(int id);

    public boolean checkexist(int id) throws NoSuchObjectException ;

    public boolean checkexist(String name);

    public List<Contact> getbyId(int id);

    public List<Contact> getbyNumber(String s);

    public List<Contact> editContactbyID(int id, int newID, String name, String number) throws NoSuchObjectException;

    public boolean wrongIdList(List<Contact> idList);

    public static void positivenumber(int a) throws ArithmeticException {

        if (a < 0) {
            System.out.println(a);
            throw new ArithmeticException("this value negative");
        }

    }

    public boolean phoneNumberLength(String a);

    public static void clearConsole() {
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

    public static int checkNumber(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                ContactInterface.positivenumber(value);
                return value;
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
            } catch (ArithmeticException a) {
                System.out.println(a);
                System.out.println("This number is negative");
                System.out.println("id");
            }
        }
    }

}
