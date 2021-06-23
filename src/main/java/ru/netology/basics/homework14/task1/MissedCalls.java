package ru.netology.basics.homework14.task1;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    private final Map<LocalDateTime, String> missedCalls = new TreeMap<>(Comparator.reverseOrder());

    public void addMissedCall(String missedCall) {
        missedCalls.put(LocalDateTime.now(), missedCall);
    }

    public void clearMissedCalls() {
        missedCalls.clear();
    }

    public String toString(Contacts contacts) {
        StringBuilder out = new StringBuilder("Список пропущенных вызовов:\n");
        for (Map.Entry<LocalDateTime, String> pair : missedCalls.entrySet()) {
            LocalDateTime time = pair.getKey();
            String phone = pair.getValue();
            out.append(time).append(" ")
                    .append(contacts.hasPhone(phone) ? contacts.find(phone) : phone)
                    .append("\n");
        }
        return out.toString();
    }
}