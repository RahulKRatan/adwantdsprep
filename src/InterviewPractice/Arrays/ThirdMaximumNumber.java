package InterviewPractice.Arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * A priority queue is basically a binary heap in Java. so each operation of inserting or deleting of this
 * queue takes O(lgK) where k is the size of the queue in this case O(lg3) which is constant. so total is O(Nlg3) ~ O(n).
 *
 * Java PriorityQueue O(n) + O(1)
 */
public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        System.out.println(thirdMax(nums));
    }
}
