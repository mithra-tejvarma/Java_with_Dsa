import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Trie Node class
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

// Trie class
class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Insert a word into trie
    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch < 'a' || ch > 'z') {
                continue;
            }

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    // Find node of given prefix
    private TrieNode searchPrefixNode(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (ch < 'a' || ch > 'z') {
                return null;
            }

            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }

    // DFS to collect suggestions
    private void collectSuggestions(TrieNode node, String currentWord, List<String> result) {
        if (node == null) {
            return;
        }

        if (node.isEndOfWord) {
            result.add(currentWord);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char nextChar = (char) ('a' + i);
                collectSuggestions(node.children[i], currentWord + nextChar, result);
            }
        }
    }

    // Get autocomplete suggestions
    public List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();

        TrieNode prefixNode = searchPrefixNode(prefix);

        if (prefixNode == null) {
            return suggestions;
        }

        collectSuggestions(prefixNode, prefix, suggestions);
        return suggestions;
    }
}

public class TextAutocompleteOptimization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();

        // Sample dictionary words
        String[] words = {
                "apple", "app", "application", "aptitude",
                "banana", "ball", "bat", "batch",
                "cat", "call", "camera", "code", "coding"
        };

        for (String word : words) {
            trie.insert(word);
        }

        System.out.print("Enter prefix for autocomplete: ");
        String prefix = sc.nextLine().toLowerCase();

        List<String> suggestions = trie.getSuggestions(prefix);

        System.out.println("\nAutocomplete Suggestions:");

        if (suggestions.isEmpty()) {
            System.out.println("No suggestions found.");
        } else {
            for (String word : suggestions) {
                System.out.println(word);
            }
        }

        sc.close();
    }
}