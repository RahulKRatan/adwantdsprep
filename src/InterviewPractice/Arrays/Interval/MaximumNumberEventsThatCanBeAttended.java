package InterviewPractice.Arrays.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberEventsThatCanBeAttended {

    public static int maxEvents(int[][] events) {
        Comparator<int[]> c= Comparator.comparingInt((int[] a) -> a[0]);
        Arrays.sort(events, c);
        int count = 1;
        for(int i=0; i<events.length-1; i++)
            if(events[i][1]<=events[i+1][0]) count+=1;

        return count;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,2},{2,3},{3,4},{1,2}};
        System.out.println(maxEvents(ints));
    }
}
