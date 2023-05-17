package impl;

import entity.*;
import inter.ContactInterface;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class ContactIMPL implements ContactInterface {

    List<Contact> contactList = new ArrayList<>();

    @Override
    public void addContact(Contact c) {
        contactList.add(c);
    }

    @Override
    public List<Contact> showContactList() {
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }
        if (contactList.size() == 0) {
            System.out.println("list is empty");
        }
        return contactList;
    }

    @Override
    public List<Contact> getContactbyName(String name) {

        List<Contact> contactNameList = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                contactNameList.add(contact);

            }

        }
        if (contactNameList.size() == 0) {
            System.out.println("this does not exist");
        }
        return contactNameList;
    }

    @Override
    public List<Contact> getbyNumber(String number) {

        List<Contact> contactNameList = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getNumber().equals(number)) {
                contactNameList.add(contact);

            }

        }
        if (contactNameList.size() == 0) {
            System.out.println("this does not exist");
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

            } else {
                wrongIdList(deleteList);
                break;
            }

        }

        contactList.removeAll(deleteList);
        return contactList;
    }

    @Override
    // bu metod gah isleyir gah islemir
    public List<Contact> editContactbyID(int id, int newID, String name, String number) throws NoSuchObjectException {
        List<Contact> editList = new ArrayList<>() {

        };
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                if (!checkexist(newID)) {
                    contact.setId(newID);
                    contact.setName(name);
                    contact.setNumber(number);
                    editList.add(contact);
                } else {
                    wrongIdList(editList);
                    break;
                }

            }

            // if (editList.isEmpty()) {
            //
            // }
        }
        return contactList;
    }

    public boolean checkexist(int id) throws NoSuchObjectException {
        for (Contact contact : contactList) {
            if (id == contact.getId()) {

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

            }

        }
        try {
            wrongIdList(idList);
        } catch (Exception e) {

        }
        return idList;
    }

    public boolean wrongIdList(List<Contact> idList) throws NoSuchElementException {
        boolean flag = true;
        if (idList.size() == 0) {

            System.out.println("id error: duplicate or non-existent");

            flag = false;
        }
        return flag;

    }

    @Override

    public boolean checkexist(String name) {

        for (Contact contact : contactList) {
            if (contact.getName().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public void createRandomContacts(int numberOfContacts) {
        Random random = new Random();

        for (int i = 0; i < numberOfContacts; i++) {
            int id1 = 1;
            int id2 = 100000000;
            int id = (int) (Math.floor(Math.random() * (id1 - id2)) + (id2));
            String name = "random person" + id / 1000;
            String number = "994" + id * 10;
            Contact contact = new Contact(id / 100000, name, number);
            contactList.add(contact);

        }
    }

    ////// deyisilecek
    @Override
    public boolean phoneNumberLength(String a) throws ArithmeticException {
        if (a.length() > 11) {

            System.out.println(a);

            throw new ArithmeticException("lenght is not 10");

        }

        return true;
    }

}
