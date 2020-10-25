package InterviewPractice.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=hLQYQ4zj0qg  - best explanation
 *
 * Time complexity : (n^3)
 * Space complexity : O(n)
 *
 */
public class WordBreak {

    // set to hold dictionary values
    private static Set<String> dictionary = new HashSet<>();

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

    /*
    recursive solution
    O(n power n) and size -> O(N)
     */
    // returns true if the word can be segmented into parts such
    // that each part is contained in dictionary
    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    /*
        recursion with memo
        O(N * 2) with O(N)
     */
    public boolean wordBreakMemo(String s, List<String> wordDict) {
        return word_BreakMem(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_BreakMem(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_BreakMem(s, wordDict, end, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict));
    }

}

/*
Time complexity : O(n^2)
Space complexity : O(n)

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
}
 */