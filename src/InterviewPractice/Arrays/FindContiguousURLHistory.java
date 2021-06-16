package InterviewPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

/** Wayfair Karat
 * Question:
 * We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person. Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.
 *
 * Sample input:
 * user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two"]
 * user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
 * user2 = ["a", "/one", "/two"]
 * user3 = ["/pink", "/orange", "/yellow","/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue","/LightGoldenRodYellow", "/BritishRacingGreen"]
 * user4 = ["/pink", "/orange","/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red","/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
 * user5= ["a"]
 * user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red","/amber"]
 *
 * Sample output:
 * findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
 * findContiguousHistory(user0, user2) => [] (empty)
 * findContiguousHistory(user0, user0) => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
 * findContiguousHistory(user2, user1) => ["a"]
 * findContiguousHistory(user5, user2) => ["a"]
 * findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
 * findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
 * findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]
 *
 * n: length of the first user's browsing history
 * m: length of the second user's browsing history
 */
public class FindContiguousURLHistory {
        public static List<String> findContiguousHistory(String[] user1, String[] user2) {
            List<String> result = new ArrayList<>();

            int[][] dp = new int[user1.length + 1][user2.length + 1];

            int max = 0;
            int endIndex = 0;

            for (int i = user1.length - 1; i >= 0; i--) {
                for (int j = user2.length - 1; j >= 0; j--) {
                    if (user1[i].equals(user2[j])) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                        if (max < dp[i][j]) {
                            max = dp[i][j];
                            endIndex = j;
                        }
                        break;
                    }
                }
            }

            for (int i = endIndex; i < endIndex + max; i++) {
                result.add(user2[i]);
            }
            return result;
        }

    public static void main(String[] args) {
        String[] user1 = new String[]{"/start", "/green", "/blue", "/pink", "/register", "/orange","/one/two"};
        String[] user2 = new String[]{"/start", "/pink", "/register", "/orange", "/red", "a"};
        System.out.println(findContiguousHistory(user1,user2));
    }
}
