package InterviewPractice.StringManipulation;


/**
 * check image in files;
 *
 * If there is no differences between the first len(s) characters, only two situations are possible :
 *
 * The strings are equal.
 *
 * The strings are one edit away distance.
 *
 *
 * Now what if there is a different character so that s[i] != t[i].
 *
 * If the strings are of the same length, all next characters should be equal to keep one edit away distance. To verify it, one has to compare the substrings of s and t both starting from the i + 1th character.
 *
 * If t is one character longer than s, the additional character t[i] should be the only difference between both strings. To verify it, one has to compare a substring of s starting from the ith character and a substring of t starting from the i + 1th character.
 *
 * Time complexity : O(N) in the worst case when string lengths are close enough abs(ns - nt) <= 1, where N is a number of characters in the longest string. O(1) in the best case when abs(ns - nt) > 1.
 *
 * Space complexity : O(N) because strings are immutable in Python and Java and to create substring costs O(N) space.
 * */
public class OneEditDistance {

    public static boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        // Ensure that s is shorter than t.
        if (ns > nt)
            return isOneEditDistance(t, s);

        // The strings are NOT one edit away distance
        // if the length diff is more than 1.
        if (nt - ns > 1)
            return false;

        for (int i = 0; i < ns; i++) {

            if (s.charAt(i) != t.charAt(i)) {

                if (ns == nt) {// if strings have the same length
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {// if strings have different length

                    return s.substring(i).equals(t.substring(i + 1));
                }

            }
        }
        // If there is no diffs on ns distance
        // the strings are one edit away only if
        // t has one more character.
        return (ns + 1 == nt);
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("a",""));
    }
}
