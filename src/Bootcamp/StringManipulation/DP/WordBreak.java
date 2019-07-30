package Bootcamp.StringManipulation.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/BreakMultipleWordsWithNoSpaceIntoSpace.java
 * Time complexity : O(n^2)
 *
 * Space complexity : O(n). Length of pp array is n+1n+1.
 *
 *  * Given a string and a dictionary, split this string into multiple words such that
 *  * each word belongs in dictionary.
 *  *
 *  * e.g peanutbutter -> pea nut butter
 *  * e.g Iliketoplay -> I like to play
 *  *
 *  * Solution
 *  * DP solution to this problem
 *  * if( input[i...j] belongs in dictionary) T[i][j] = i
 *  * else{
 *  *     T[i][j] = k if T[i][k-1] != -1 && T[k][j] != -1
 *  *
 *  * Test cases
 *  * 1) Empty string
 *  * 2) String where entire string is in dictionary
 *  * 3) String which cannot be split into words which are in dictionary
 *  * 3) String which can be split into words which are in dictionary
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] T = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        T[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(T[j] && set.contains(s.substring(j, i))) {
                    T[i] = true;
                    break;
                }
            }
        }
        return T[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict));
    }

}
