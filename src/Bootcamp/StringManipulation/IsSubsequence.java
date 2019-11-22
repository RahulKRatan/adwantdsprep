package Bootcamp.StringManipulation;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;

        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }

            j++;

            if(i==s.length())
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}

/*
class Solution {//beat 100% super fast and super easy
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }
}
 */

/*
/**
 * Follow-up
 * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t.
 * This is inefficient.
 * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t.
 * Sounds like a HashMap, which is super suitable for search for existing stuff.

public boolean isSubsequence(String s, String t) {
    if (s == null || t == null) return false;

    Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

    //preprocess t
    for (int i = 0; i < t.length(); i++) {
        char curr = t.charAt(i);
        if (!map.containsKey(curr)) {
            map.put(curr, new ArrayList<Integer>());
        }
        map.get(curr).add(i);
    }

    int prev = -1;  //index of previous character
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (map.get(c) == null)  {
            return false;
        } else {
            List<Integer> list = map.get(c);
            prev = binarySearch(prev, list, 0, list.size() - 1);
            if (prev == -1) {
                return false;
            }
            prev++;
        }
    }

    return true;
}

    private int binarySearch(int index, List<Integer> list, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < index) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start == list.size() ? -1 : list.get(start);
    }
 */