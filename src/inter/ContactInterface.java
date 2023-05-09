package inter;

import java.util.List;

import entity.*;


public interface ContactInterface {
    public void addContact(Contact c);

    List<Contact> showContactList();

    public List<Contact> getContactbyName(String name);

    public List<Contact> deleteContactbyID(int id);

    public boolean checkexist(int id);

    public List<Contact> editContactbyID(int id,int newID, String name, String number);

}
