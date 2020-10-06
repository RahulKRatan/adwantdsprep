package InterviewPractice.Arrays.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberEventsThatCanBeAttended {

    public static int maxEvents(int[][] events) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int i = 0, res = 0, d = 0, n = events.length;
        while (!minHeap.isEmpty() || i < n) {
            if (minHeap.isEmpty())
                d = events[i][0];
            while (i < n && events[i][0] <= d)
                minHeap.offer(events[i++][1]);
            minHeap.poll();
            ++res; ++d;
            while (!minHeap.isEmpty() && minHeap.peek() < d)
                minHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,2},{2,3},{3,4},{1,2}};
        System.out.println(maxEvents(ints));
    }
}
