package ru.netology;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static PhoneContacts phoneContacts = new PhoneContacts(new HashMap<String, List <Contact>>());

    public static void main(String[] args) {


        printHiMessage();
        askAndcreateGroups();
        createContactAndAddItToGroupe();
        phoneContacts.print();
        scanner.close();
    }


    public static void askAndcreateGroups () {
        while (true) {
            String group = scanner.nextLine();
            if (group.equals("нет")) {
                break;
            }
            phoneContacts.createGroup(group);
            System.out.println("Создать ещё одну группу (введите \"нет\"для для перехода к созданию контактов)? ");
        }
    }


    public static void printHiMessage() {
        System.out.println("Программа справочник\n" + "Введите название группы контактов:");
    }


    public static void createContactAndAddItToGroupe() {
        while (true) {
            System.out.println("Создать контакт?" + " Для создания введите имя."
                    +" Для завершения введите \"нет\" ");
            String contactName = scanner.nextLine();
            if (contactName.equals("нет")){
                break;
            }
            System.out.println("введите номер телефона");
            String phoneNumber = scanner.nextLine();


            System.out.println("Введите через пробел группы, в которые нужно положить контакт:");
            String inputGroups = scanner.nextLine();
            String[] splitGroups = inputGroups.split(" ");


            phoneContacts.addContactToGroup(new Contact(contactName, phoneNumber), splitGroups);
        }
    }
}