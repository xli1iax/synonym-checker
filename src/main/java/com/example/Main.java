package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SynonymChecker synonymChecker = new SynonymChecker();
        int testsCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testsCount; i++) {
            int pairsCount = Integer.parseInt(sc.nextLine());

            //create a dictionary of synonyms
            for (int j = 0; j < pairsCount; j++) {
                String[] words = sc.nextLine().split(" ");

                synonymChecker.addSynonym(words[0].toLowerCase(), words[1].toLowerCase());
            }

            pairsCount = Integer.parseInt(sc.nextLine());

            //checking pairs to see if they are synonyms
            for (int j = 0; j < pairsCount; j++) {
                String[] words = sc.nextLine().split(" ");

                synonymChecker.areSynonyms(words[0].toLowerCase(), words[1].toLowerCase());
            }
            synonymChecker.clearSynonyms();
        }

    }
}