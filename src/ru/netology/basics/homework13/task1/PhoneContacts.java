package ru.netology.basics.homework13.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneContacts {

    private Map<String, List<Contact>> groups;

    public PhoneContacts(Map<String, List<Contact>> groups) {
        this.groups = groups;
    }

    public boolean createGroup(String groupName) {
        if (!groups.containsKey(groupName)) {
            groups.put(groupName, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addContact(Contact contact, String groupName) {
        if (groups.containsKey(groupName)) {
            groups.get(groupName).add(contact);
            return true;
        }
        return false;
    }

    public Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

    public boolean isEmpty() {
        return groups.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Группы в справочнике:\n");

        for (Map.Entry<String, List<Contact>> pair : groups.entrySet()) {
            if (!pair.getValue().isEmpty()) {
                out.append(pair.getKey()).append(":\n");

                for (Contact c : pair.getValue()) {
                    out.append("\t").append(c).append("\n");
                }
            }
        }

        return out.toString();
    }
}