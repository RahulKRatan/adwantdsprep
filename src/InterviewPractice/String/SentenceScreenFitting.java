package InterviewPractice.String;

/**
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
 *
 *Based on the above observation, in the first for loop we compute the number of words that can be placed in the row if ith word is used as the starting word.
 * This is saved as dp[i]. Note that this value can be greater than n.
 * In the next for loop we calculate how many words are placed in each row based on dp[i].
 * Imagine placing the 0th word in the row-0, then this row will hold dp[0] words. Next, which word will be placed on the start of next row?
 * We calculate that using dp[k] % n (Remember dp[i] can be greater than n).
 */
public class SentenceScreenFitting {

    public static int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            int length = 0, words = 0, index = i;
            while(length + sentence[index % n].length() <= cols) {
                length += sentence[index % n].length();
                length += 1; // space
                index++;
                words++;
            }
            dp[i] = words;
        }

        int words = 0;
        for(int i = 0, index = 0; i < rows; i++) {
            words += dp[index];
            index = (dp[index] + index) % n;
        }

        return words / n;
    }


    public static void main(String[] args) {
        String [] data = { "a", "bcd", "e" };
        System.out.println(wordsTyping(data,3,6));
    }
}

/*
 public static int wordsTyping(String[] sentence, int rows, int cols) {
        int i = 0;
        int cnt = 0;

        int k = 0;  //kth word
        int colLen = cols;

        while (i < rows) {
            String sen = sentence[k++];
            // if length of word is larger than column then return 0
            if (sen.length() > cols) {
                return 0;
            }


            if (colLen >= sen.length()) { // modify colLen after occuping string and a space
                colLen = colLen - sen.length() - 1;
            } else {  // if in a row, colLength doesnt fit a string.. go to next row and reset colLenth
                i++;
                colLen = cols;
                colLen = colLen - sen.length() - 1;
            }

            // if reached row limit then return count
            if (i >= rows) {
                return cnt;
            }

            // if all strings of sentence is covered, increment count and reset k.
            if (k == sentence.length) {
                cnt++;
                k = 0;
            }
        }

        return cnt;
    }
 */