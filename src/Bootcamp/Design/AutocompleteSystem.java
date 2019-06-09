package Bootcamp.Design;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {

    }

    public List<String> input(char c) {

    }


}
