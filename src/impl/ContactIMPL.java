package impl;

import entity.*;
import inter.ContactInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactIMPL implements ContactInterface {

    List<Contact> contactList = new ArrayList<>();

    // Contact c1 = new Contact(1, "nurgun", "22");
    // Contact c2 = new Contact(2, "ulker", "2");
    // Contact c3 = new Contact(3, "gulnar", "16");

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
            if (contact.getNumber().equals(number)) {
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

    // @Override
    // public List<Contact> addContactList(List<Contact> listWithRandom) {
    // listWithRandom = new ArrayList<>();
    // showContactList().addAll(listWithRandom);
    // return showContactList();

    // }
    public void createRandomContacts(int numberOfContacts) {
        Random random = new Random();

        for (int i = 0; i < numberOfContacts; i++) {
            int id1 = 1;
            int id2 = 100;
            int id= (int) (Math.floor(Math.random() * (id1 - id2)) + (id2));

             // Generate a random ID
            String name = "random person" + id; // Generate a random name (implement this method separately)
            String number = "1" + id * 10; // Generate a random number (implement this method separately)

            Contact contact = new Contact(id, name, number);
            contactList.add(contact);

        }
    }

    // @Override
    // public List<Contact> Randomlist(int a) {
       
    //     return contactList;
    // }

}
