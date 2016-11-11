package com.amazon;

import java.util.*;

/**
 * Created by kaibohao on 2016-11-10.
 */
public class Contacts {
    private Tries tries = new Tries();

    public void addContact(String contact) {
        if (contact == null || contact.isEmpty())
            return;
        if (this.tries == null)
            this.tries = new Tries();
        Tries currentTries = this.tries;
        for (Character c : contact.toCharArray()) {
            if (currentTries.children == null) {
                currentTries.children = new HashMap<>();
            }
            if (!currentTries.children.containsKey(c))
                currentTries.children.put(c, new Tries());
            currentTries.childWordCount++;
            currentTries = currentTries.children.get(c);
        }
        currentTries.isCompleteWord = true;
    }

    public int findContacts(String keyword) {
        StringBuilder characters = new StringBuilder();
        if (tries == null)
            return 0;
        Tries currentTries = tries;
        if (currentTries.children == null) {
            return 0;
        }
        for (Character c : keyword.toCharArray()) {
            if (currentTries == null || currentTries.children == null)
                return 0;
            if (currentTries.children.containsKey(c)) {
                currentTries = currentTries.children.get(c);
            } else {
                return 0;
            }
        }
        int count = currentTries.childWordCount;
        if (currentTries.isCompleteWord) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Contacts contacts = new Contacts();
        List<Integer> countList = new ArrayList<>();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            if ("add".equals(op)) {
                contacts.addContact(contact);
            } else if ("find".equals(op)) {
                int count = contacts.findContacts(contact);
                System.out.println(count);
            }
        }
    }
}


