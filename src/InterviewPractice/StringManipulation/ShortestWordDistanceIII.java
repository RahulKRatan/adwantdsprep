package InterviewPractice.StringManipulation;

public class ShortestWordDistanceIII {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int turn = 0;
        if(word1.equals(word2)){
            turn = 1;
        }
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && (turn == 1 || turn == 0)) {
                i1 = i;
                if(turn == 1) turn = 2;
            } else if (words[i].equals(word2) && (turn == 2 || turn == 0)) {
                i2 = i;
                if(turn == 2) turn = 1;
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


/*
i1 and i2 are the indexes where word1 and word2 were last seen. Except if they're the same word, then i1 is the previous index.
public int shortestWordDistance(String[] words, String word1, String word2) {
    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
    for (int i=0; i<words.length; i++) {
        if (words[i].equals(word1))
            i1 = i;
        if (words[i].equals(word2)) {
            if (word1.equals(word2))
                i1 = i2;
            i2 = i;
        }
        dist = Math.min(dist, Math.abs(i1 - i2));
    }
    return (int) dist;
}
 */