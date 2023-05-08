package inter;

import java.util.List;

import entity.*;
import impl.*;

public interface ContactInterface {
    public void addContact(Contact c);

    List<Contact> showContactList();

    public List<Contact> getContactbyName(String name);

    public List<Contact> deleteContactbyID(int id);

    public List<Contact> editContactbyID(int id,int newID, String name, String number);

}
