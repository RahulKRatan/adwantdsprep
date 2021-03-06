package InterviewPractice.String;


/**
 * O(N) and O(1)
 */
public class ShortestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance(strings,"makes","coding"));
    }
}
