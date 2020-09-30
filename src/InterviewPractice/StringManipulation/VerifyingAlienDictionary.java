package InterviewPractice.StringManipulation;

/**
 * Time O(NS)
 * Space O(1)
 *
 * N is the length of words since we go through the words list to compare each string with its previous one.
 * S is the max length of word in the words list since in the helper function, the worst case is encounter the max string.
 */
public class VerifyingAlienDictionary {
    static int[] mapping = new int[26];
    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++)
            mapping[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++)
            if (bigger(words[i - 1], words[i]))
                return false;
        return true;
    }

    static boolean bigger(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        for (int i = 0; i < n && i < m; ++i)
            if (s1.charAt(i) != s2.charAt(i))
                return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
        return n > m;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted(words,order));
        String[] words2 = new String[]{"hello","leetcode"};
        System.out.println(isAlienSorted(words2,order));
    }
}
