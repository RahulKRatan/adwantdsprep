package InterviewPractice.String;

import java.util.ArrayList;
import java.util.List;

/**
 * We need an array last[char] -> index of S where char occurs last.
 * Then, let anchor and j be the start and end of the current partition.
 * If we are at a label that occurs last at some index after j, we'll extend the partition j = last[c].
 * If we are at the end of the partition (i == j) then we'll append a partition size to our answer, and set the start of our new partition to i+1.
 *
 *
 * Time Complexity: O(N), where N is the length of S.
 *
 * Space Complexity: O(1) we are only using constant 26 character length string
 */
public class PartitionLabels {

    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i; // this will have last entry of that alphabet in the string

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']); // we check here if we reached last element of labels and reset anchor
            if (i == j) { // we check here if we reached last element of labels and add and reset anchor
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String string = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(string);
        System.out.println(result);
    }
}
