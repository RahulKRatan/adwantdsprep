package InterviewPractice.Arrays;

import java.util.*;

/**
 * If M = 26 alphabet characters
 * Java, O(NM+(M^2 * logM)), Sort by high rank vote to low rank vote
 *
 * Time O(NM) for iterating
 * Time O(MMlogM) for sorting
 * Space O(M^2)
 * where N = votes.length and M = votes[0].length <= 26
 *
 */
public class RankTeamsByVotes {

    public static String rankTeams(String[] votes) {

        Map<Character, int[]> map = new HashMap<>();
        int l = votes[0].length();

        // Iterating and storing in map - A->5,0,0 || B->0,2,3 || C->0,3,2
        for(String vote : votes){
            for(int i = 0; i < l; i++){
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[l]);
                map.get(c)[i]++;
            }
        }

        // Sorting the hashmap in descending order if no clash or natural ordering
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
            for (int i = 0; i < l; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i]; //a - b = ASC & b - a = DESC - because we want to sort in descending order of the number of occurrences of the character. Only when there is a tie we want to sort based on natural ordering and hence doing "a - b" outside the for loop
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    String[] votes = new String[]{"ABC","ACB","ABC","ACB","ACB"};
    System.out.println(rankTeams(votes));
    }
}


