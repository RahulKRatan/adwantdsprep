package Bootcamp.StringManipulation;

/**
 1. Thoughts
 - from back to front
 - if count > 0 && != #, skip
 - if count == 0 && different, return false
 - if #, count++
 - if one ends, the other count == 0 && has any char return false
 - else return true
 */
public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') countS++;
                else countS--; // backspacing after #
                i--;
            }
            char left = i < 0 ? '@' : S.charAt(i);
            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') countT++;
                else countT--; // backspacing after #
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);
            if (left != right) return false;
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
    }
}
