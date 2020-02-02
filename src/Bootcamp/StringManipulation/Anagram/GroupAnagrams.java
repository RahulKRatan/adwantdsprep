package Bootcamp.StringManipulation.Anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Two strings are anagrams if and only if their sorted strings are equal.
 * Maintain a map ans : {String -> List} where each key K is a sorted string, and each value is the list of strings from the initial input that when sorted, are equal to K.
 *
 * In Java, we will store the key as a string, eg. code
 * Time Complexity: O(NKlog K), where N is the length of strs, and K is the maximum length of a string in strs.
 * The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.
 *
 * Space Complexity: O(NK), the total information content stored in ans.
 */

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> tempResult = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(tempResult.containsKey(sorted)){
                List<String> abc = tempResult.get(sorted);
                abc.add(str);
                tempResult.put(sorted,abc);
            }
            else {
                List<String> cde = new ArrayList<>();
                cde.add(str);
                tempResult.put(sorted,cde);
            }
        }
        return new ArrayList<>(tempResult.values());
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }
}
