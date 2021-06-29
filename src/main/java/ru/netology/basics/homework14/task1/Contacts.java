package ru.netology.basics.homework14.task1;

import java.util.HashMap;
import java.util.Map;

public class Contacts {

    private final Map<String, Contact> contacts = new HashMap<>();

    public boolean add(String name, String surname, String phone, String group) {
        if (isValidGroup(group)) {
            contacts.put(phone, new Contact(name, surname, phone, Group.valueOf(group)));
        }
        return isValidGroup(group);
    }

    public boolean delete(String name, String surname) {
        for (Contact contact : contacts.values()) {
            if (contact.getName().equals(name) && contact.getSurname().equals(surname)) {
                contacts.remove(contact.getPhone());
                return true;
            }
        }
        return false;
    }

    public Contact find(String phone) {
        return contacts.get(phone);
    }

    public boolean hasPhone(String phone) {
        return contacts.containsKey(phone);
    }

    public boolean edit(String newName, String newSurname, String phone, String newGroup) {
        if (!contacts.containsKey(phone) || !isValidGroup(newGroup)) {
            return false;
        }

        Contact c = contacts.get(phone);

        c.setName(newName);
        c.setSurname(newSurname);
        c.setGroup(Group.valueOf(newGroup));
        return true;
    }

    public void clear() {
        contacts.clear();
    }

    public int size() {
        return contacts.size();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Список контактов:\n");
        for (Contact contact : contacts.values()) {
            out.append(contact).append("\n");
        }
        return out.toString();
    }

    private boolean isValidGroup(String group) {
        try {
            Group.valueOf(group);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}