package InterviewPractice.Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, Collections.reverseOrder());
        for(int stone: stones){
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1){
            int diff = maxHeap.poll()-maxHeap.poll();
            if(diff > 0){
                maxHeap.add(diff);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,4,1,8,1};
        System.out.println(lastStoneWeight(nums));
    }
}
