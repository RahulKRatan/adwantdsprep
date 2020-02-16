package Bootcamp.StringManipulation.DP;

import java.util.*;

public class WordBreak2 {

    /*
    recursive solution with memoization
     */

    public static List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, new HashSet<>(wordDict), new HashMap<>());
    }
    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wordBreak("catsanddog", wordDict));
    }

}
