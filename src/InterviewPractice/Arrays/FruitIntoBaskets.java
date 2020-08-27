package InterviewPractice.Arrays;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] tree) {
        int windowStart = 0, maxLength = 0;
        Map<Integer, Integer> fruitFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < tree.length; windowEnd++) {
            fruitFrequencyMap.put(tree[windowEnd], fruitFrequencyMap.getOrDefault(tree[windowEnd], 0) + 1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(tree[windowStart], fruitFrequencyMap.get(tree[windowStart]) - 1);
                if (fruitFrequencyMap.get(tree[windowStart]) == 0) {
                    fruitFrequencyMap.remove(tree[windowStart]);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] fruits = new int[]{0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
}
