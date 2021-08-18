package ru.netology;

import org.junit.jupiter.api.Assertions;

import java.util.*;


import static ru.netology.Main.phoneContacts;

class PhoneContactsTest {

    @org.junit.jupiter.api.Test
    void createGroup() {
        String testStr = "Test";
        List<Contact> testList = new ArrayList<>();
        Map<String, List<Contact>> expected = new HashMap<String,List<Contact>>();
        expected.put(testStr,testList);
        phoneContacts.createGroup(testStr);
        Assertions.assertTrue(phoneContacts.getGroups().containsKey(testStr));
    }

    @org.junit.jupiter.api.Test
    void addContactToGroup() {
        Contact testContact = new Contact("IVAN","11213121");
        String[] groups = new String[1];
        groups[0] = "Семья";
        phoneContacts.addContactToGroup(testContact, groups);
        Assertions.assertTrue(phoneContacts.getGroups().get(groups[0]).contains(testContact));
    }

    @org.junit.jupiter.api.Test
    void print() {
        Contact testContact = new Contact("IVAN","11213121");
        String[] groups = new String[1];
        groups[0] = "Семья";
        phoneContacts.addContactToGroup(testContact, groups);
        String testString = "";
        for ( Map.Entry<String, List <Contact>> entry : phoneContacts.getGroups().entrySet()) {
            testString = "Группа: " + entry.getKey() + "\nСписок контактов: \n" + entry.getValue();
        }
        Assertions.assertNotNull(testString);
    }
}