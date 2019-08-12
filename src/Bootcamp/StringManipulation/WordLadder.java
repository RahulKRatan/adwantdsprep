package Bootcamp.StringManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/discuss/40704/Java-Solution-using-BFS-with-explanation
 * Basically I keep two sets of words, one set reached that represents the borders that have been reached with "distance" steps; another set wordDict
 * that has not been reached. In the while loop, for each word in the reached set, I give all variations and check if it matches anything from wordDict,
 * if it has a match, I add that word into toAdd set, which will be my "reached" set in the next loop, and remove the word from wordDict because I already
 * reached it in this step. And at the end of while loop, I check the size of toAdd, which means that if I can't reach any new String from wordDict,
 * I won't be able to reach the endWord, then just return 0. Finally if the endWord is in reached set, I return the current steps "distance".
 *
 * The idea is that reached always contain only the ones we just reached in the last step, and wordDict always contain the ones that haven't been reached.
 * This is pretty much what Dijkstra's algorithm does, or you can see this as some variation of BFS.
 */


public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        // HERE
        //dict.add(endWord);
        reached.add(beginWord);
        int ladder = 1;
        while (!reached.contains(endWord)){
            Set<String> toAdd = new HashSet<>();
            for (String str:reached){
                for (int i=0;i<str.length();i++){
                    char[] chars = str.toCharArray();
                    for (char ch = 'a';ch<='z';ch++){
                        chars[i] = ch;
                        String newStr = new String(chars);
                        if (dict.contains(newStr)){
                            toAdd.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                }
            }
            ladder += 1;
            if (toAdd.size() == 0)
                return 0;
            reached = toAdd;
        }
        return ladder;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");wordList.add("dot");wordList.add("dog");wordList.add("lot");wordList.add("log");wordList.add("cog");
        System.out.println(ladderLength(beginWord,endWord,wordList));
    }

}
