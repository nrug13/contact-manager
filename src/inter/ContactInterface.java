package inter;

import java.util.List;
import java.util.Scanner;

import entity.*;


public interface ContactInterface {
    public void addContact(Contact c);

    List<Contact> showContactList();

    // public List<Contact> Randomlist(int a);

    public List<Contact> getContactbyName(String name);

    public List<Contact> deleteContactbyID(int id);

    public boolean checkexist(int id);
    
    public boolean checkexist(String name);

    public List <Contact> getbyId(int id);

    public List<Contact> getbyNumber(String s);

    public List<Contact> editContactbyID(int id,int newID, String name, String number);
    

}
