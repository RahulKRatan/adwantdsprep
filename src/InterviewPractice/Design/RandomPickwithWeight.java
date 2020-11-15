package InterviewPractice.Design;


/**
 * In other words, the probability that a number got picked is proportional to the value of the number, with regards to the total sum of all numbers.
 * Once we randomly generate the target offset, the task is now boiled down to finding the range that this target falls into.
 */
public class RandomPickwithWeight {
    private static int[] prefixSums;
    private static int totalSum;
    public RandomPickwithWeight(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = totalSum * Math.random();
        int i = 0;
        // run a linear search to find the target zone
        for (; i < prefixSums.length; ++i) {
            if (target < prefixSums[i])
                return i;
        }
        // to have a return statement, though this should never happen.
        return i - 1;
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 3};
        RandomPickwithWeight randomPickwithWeight = new RandomPickwithWeight(w);
        System.out.println(randomPickwithWeight.pickIndex());
        System.out.println(randomPickwithWeight.pickIndex());
        System.out.println(randomPickwithWeight.pickIndex());
    }
}
