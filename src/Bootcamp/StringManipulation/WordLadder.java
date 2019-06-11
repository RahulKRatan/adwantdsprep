package Bootcamp.StringManipulation;

import java.util.HashSet;
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

    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }

}
