package Bootcamp.StringManipulation;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        char temp1[] = s.toCharArray();
        char temp2[] = t.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        String s1 = new String(temp1);
        String s2 = new String(temp2);
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }
//we could increment the counter for each letter in ss and decrement the counter for
// each letter in tt, then check if the counter reaches back to zero.
    // efficient way using counter;
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] counter = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            counter[s.charAt(i) - 'a']++;
//            counter[t.charAt(i) - 'a']--;
//        }
//        for (int count : counter) {
//            if (count != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cat","tac"));
    }


}
