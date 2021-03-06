package InterviewPractice.DP;

/**
 * Time complexity : O(n^2)
 * Space complexity : O(1).
 *
 * we need to save start index i.e. lo and maxLength i.e. maxLen to find substring of palindrome
 *
 */
public class LongestPalindromicSubstring {
    private static int lo, maxLen;
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
