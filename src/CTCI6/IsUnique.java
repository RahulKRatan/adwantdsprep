package CTCI6;

/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */

public class IsUnique {
    static boolean[] boo = new boolean[26];

    public static boolean testUnique(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (boo[str.charAt(i) - 97]) {
                return false;
            } else {
                boo[str.charAt(i) - 97] = true;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String str = "goutam";
        System.out.println("String isUnique : " + testUnique(str));
    }
}
// check another solution using bit vector
