package InterviewPractice.StringManipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Sort the words by word's length. (also can apply bucket sort)
 * For each word, loop on all possible previous word with 1 letter missing.
 * If we have seen this previous word, update the longest chain for the current word.
 * Finally return the longest word chain.
 * O(NlogN + NL^2)
 */
public class LongestStringChain {
    public static int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());//Sort the words by word's length
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {//For each word, loop on all possible previous word with 1 letter missing.
                String prev = word.substring(0, i) + word.substring(i + 1);// this makes it L2 complexity for each string.. so its N*Lsquare
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);//If we have seen this previous word, update the longest chain for the current word.
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;//Finally return the longest word chain.
    }
    public static void main(String[] args) {
        String[] words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStrChain(words));
    }
}
