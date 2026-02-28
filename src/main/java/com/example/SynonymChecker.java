package com.example;

import java.util.*;

public class SynonymChecker {
    private Map<String, Set<String>> synonyms;

    public SynonymChecker() {
        this.synonyms = new HashMap<>();
    }

    public void addSynonym(String word1, String word2) {
        synonyms.computeIfAbsent(word1, k -> new HashSet<>()).add(word2);
        synonyms.computeIfAbsent(word2, k -> new HashSet<>()).add(word1);
    }

    public boolean areSynonyms(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        }
        return breadthFirstSearch(word1, word2);
    }

    private boolean breadthFirstSearch(String word1, String word2) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(word1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            visited.add(word);

            if (word.equals(word2)) {
                return true;
            }
            Set<String> values = synonyms.getOrDefault(word, new HashSet<>());

            for (String value : values) {
                if (word2.equals(value)) return true;

                if (!visited.contains(value)) {
                    queue.add(value);
                    visited.add(value);
                }

            }
        }
        return false;
    }

    public void clearSynonyms() {
        synonyms.clear();
    }
}
