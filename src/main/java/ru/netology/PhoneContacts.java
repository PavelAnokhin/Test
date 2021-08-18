package ru.netology;

import java.util.*;

public class PhoneContacts {


    private Map <String, List <Contact>> groups;

    public PhoneContacts(Map<String, List<Contact>> groups) {
        this.groups = groups;
    }

    //создаём новую группу и сразу кладём её в мапу
    public void createGroup(String group) {
        List<Contact> newGroup = new ArrayList<>();
        groups.put(group, newGroup);
    }

    //добавление контакта в группу
    public void addContactToGroup (Contact contact, String[] group) {
        for (String str : group) {
            if (groups.containsKey(str) == false){
                createGroup(str);
            }
            groups.get(str).add(contact);
        }
    }

    //отображение групп
    public void print(){
        for ( Map.Entry<String, List <Contact>> entry : groups.entrySet()) {
            System.out.println("Группа: " + entry.getKey() + "\nСписок контактов: \n" + entry.getValue() );
        }
    }

    public Map<String, List<Contact>> getGroups() {
        return groups;
    }
}