package impl;

import entity.*;
import inter.ContactInterface;

import java.util.ArrayList;
import java.util.List;

public class ContactIMPL implements ContactInterface {

    List<Contact> contactList = new ArrayList<>();

    @Override
    public void addContact(Contact c) {
        contactList.add(c);
    }

    @Override
    public List<Contact> showContactList() {

        // for (Contact contact : contactList) {
        // System.out.println(contact);
        // }
        return contactList;
    }

    @Override
    public List<Contact> getContactbyName(String name) {

        List<Contact> contactNameList = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                contactNameList.add(contact);
                // System.out.println(contactNameList);

            } 
            

        }
        
        return contactNameList;
    }

    @Override
    public List<Contact> deleteContactbyID(int id) {
        List<Contact> deleteList = new ArrayList<>();
        for (Contact contact : contactList) {
            if (id == contact.getId()) {
                // System.out.println(contact.getClass());
                deleteList.add(contact);
                System.out.println("this is going to be deleted " + deleteList);

            } else if (id != contact.getId()) {
                System.out.println("no such id exists");
            }
        }
        contactList.removeAll(deleteList);
        return contactList;
    }

    @Override
    public List<Contact> editContactbyID(int id, int newID, String name, String number) {
        for (Contact contact : contactList) {
            if (id == contact.getId()) {
                contact.setId(newID);
                contact.setName(name);
                // contact.setSurname(surname);
                contact.setNumber(number);
            } else if (id != contact.getId()) {
                System.out.println("no such name exists");
            }
        }
        return contactList;
    }

}
