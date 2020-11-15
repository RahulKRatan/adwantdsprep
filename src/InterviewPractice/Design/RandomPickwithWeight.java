package InterviewPractice.Design;


/**
 * In other words, the probability that a number got picked is proportional to the value of the number, with regards to the total sum of all numbers.
 * Once we randomly generate the target offset, the task is now boiled down to finding the range that this target falls into.
 *
 * As many of you might recognize now, the offsets of the ranges are actually the prefix sums from a sequence of numbers.
 * For each number in a sequence, its corresponding prefix sum, also known as cumulative sum, is the sum of all previous numbers in the sequence plus the number itself.
 *
 * Time Complexity
 *
 * For the constructor function, the time complexity would be O(N), which is due to the construction of the prefix sums.
 * For the pickIndex() function, its time complexity would be O(N) as well, since we did a linear search on the prefix sums.
 *
 * Space Complexity
 *
 * For the constructor function, the space complexity would be O(N), which is again due to the construction of the prefix sums.
 * For the pickIndex() function, its space complexity would be O(1), since it uses constant memory. Note, here we consider the prefix sums that it operates on, as the input of the function.
 *
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
