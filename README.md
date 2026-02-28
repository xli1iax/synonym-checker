# Synonym Checker

A Java program that determines whether two words are synonyms using a given synonym dictionary and transitivity rules (if A = B and B = C, then A = C).

## How it works
1. Reads number of test cases T
2. For each test case:
   - Loads N synonym pairs
   - Builds a graph of connections (Map<String, Set<String>>)
   - Answers Q queries using BFS search
   - Case-insensitive (all words converted to lowercase)
   - Clears data before next test case
