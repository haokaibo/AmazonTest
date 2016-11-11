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
            currentTries = currentTries.children.get(c);
        }
        currentTries.isCompleteWord = true;
    }

    public int findContacts(String keyword) {
        List<String> contacts = findContactsByKeyword(keyword);
        return contacts == null ? 0 : contacts.size();
    }

    public List<String> findContactsByKeyword(String keyword) {
        StringBuilder characters = new StringBuilder();
        if (tries == null)
            return null;
        Tries currentTries = tries;
        if (currentTries.children == null) {
            return null;
        }
        for (Character c : keyword.toCharArray()) {
            if (currentTries == null || currentTries.children == null)
                return null;
            if (currentTries.children.containsKey(c)) {
                characters.append(c);
                currentTries = currentTries.children.get(c);
            } else {
                return null;
            }
        }
        List<String> contacts = new ArrayList<>();
        if (currentTries.isCompleteWord) {
            contacts.add(characters.toString());
        }
        findAllContacts(currentTries, characters, contacts);
        return contacts;
    }

    private void findAllContacts(Tries tries, StringBuilder currentKeywords, List<String> foundContacts) {
        if (tries == null)
            return;
        if (tries.children != null) {
            tries.children.forEach((k, v) -> {
                StringBuilder preWords = new StringBuilder();
                preWords.append(currentKeywords);
                preWords.append(k);
                if (v.isCompleteWord) {
                    foundContacts.add(preWords.toString());
                }
                findAllContacts(v, preWords, foundContacts);
            });
        }
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
//        for (Integer c : countList) {
//            System.out.println(c);
//        }
    }

}


