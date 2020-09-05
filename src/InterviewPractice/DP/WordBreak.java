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
     */
    // returns true if the word can be segmented into parts such
    // that each part is contained in dictionary
    public static boolean wordBreak(String word)
    {
        int size = word.length();

        // base case
        if (size == 0)
            return true;

        //else check for all words
        for (int i = 1; i <= size; i++)
        {
            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is
            // present in dictionary ,if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.

            if (dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,size)))
                return true;
        }

        // if all cases failed then return false
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict));
    }

}
