package com.twitter;

import java.util.*;

/*
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

 */
public class AutoCompleteSystem {
    public class Tries {
        HashMap<Character, Tries> children;
        boolean isCompleteWord;
    }

    Tries tries;

    public String[] queryString(String[] strings, String keyword) {
        if (strings == null || strings.length == 0) {
            return null;
        }

        if (this.tries == null) {
            this.tries = new Tries();
        }
        for (String s : strings) {
            Tries current = this.tries;
            for (Character c : s.toCharArray()) {
                if (current.children == null) {
                    current.children = new HashMap<>();
                }
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new Tries());
                }
                current = current.children.get(c);
            }
            current.isCompleteWord = true;
        }

        Tries current = this.tries;
        List<String> matches = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Character c : keyword.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return null;
            } else {
                sb.append(c);
                if (current.children.get(c).isCompleteWord) {
                    matches.add(sb.toString());
                }
            }
            current = current.children.get(c);
        }

        iterateTries(current, sb, matches);

        return matches.toArray(new String[0]);
    }

    public void iterateTries(Tries tries, StringBuilder sb, List<String> matches) {
        if (tries == null)
            return;
        if (tries.isCompleteWord){
            matches.add(sb.toString());
            return;
        }
        if (tries.children == null)
            return;
        Iterator<Map.Entry<Character, Tries>> iterator = tries.children.entrySet().iterator();
        while(iterator.hasNext()){
            StringBuilder sbTemp = new StringBuilder(sb);
            Map.Entry<Character, Tries> child = iterator.next();
            sbTemp.append(child.getKey());
            Tries current = child.getValue();
            iterateTries(current, sbTemp, matches);
        }
    }

    public static void main(String[] args) {
        String[] result = new AutoCompleteSystem().
                queryString(new String[]{"dog", "deer", "deal"}, "de");

        for (String s : result){
            System.out.println(s);
        }
    }
}
