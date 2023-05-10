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
    public List<Contact> getbyNumber(String number) {

        List<Contact> contactNameList = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().equals(number)) {
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

            }

        }
        contactList.removeAll(deleteList);
        return contactList;
    }

    @Override
    public List<Contact> editContactbyID(int id, int newID, String name, String number) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                contact.setId(newID);
                contact.setName(name);
                contact.setNumber(number);
            }
           
        }    
        return contactList;
    }

    public boolean checkexist(int id) {
        for (Contact contact : contactList) {
            if (id == contact.getId()) {
                // System.out.println("this already exists");
                return true;
            }
            

        }
        return false;

    }

    @Override
    public List<Contact> getbyId(int id) {
        List<Contact> idList = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                idList.add(contact);
                // System.out.println(contactNameList);

            }

        }

        return idList;
    }

    @Override

    public boolean checkexist(String name) {

        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                // System.out.println("this already exists");
                return true;
            }
            

        }
        return false;
    }

}
