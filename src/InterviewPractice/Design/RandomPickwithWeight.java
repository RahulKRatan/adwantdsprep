package InterviewPractice.Design;

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
