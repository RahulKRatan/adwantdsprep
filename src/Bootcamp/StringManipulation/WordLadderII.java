package Bootcamp.StringManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-ladder-ii/discuss/40475/My-concise-JAVA-solution-based-on-BFS-and-DFS
 */
public class WordLadderII {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {


        return null;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");wordList.add("dot");wordList.add("dog");wordList.add("lot");wordList.add("log");wordList.add("cog");
        List<List<String>> result = findLadders(beginWord,endWord,wordList);
        System.out.println(result);
    }
}
