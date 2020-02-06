package Bootcamp.Arrays.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals) {
        int[] left = new int[intervals.length];
        int[] right = new int[intervals.length];

        for(int i=0;i<intervals.length;i++){
            left[i] = intervals[i][0];
            right[i] = intervals[i][1];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        for(int i=1;i<left.length;i++){
            if(left[i]<right[i-1]){
                return false;
            }
        }

        return true;
    }

    /**
     * The idea here is to sort the meetings by starting time. Then, go through the meetings one by one and make sure that each meeting ends before the next one starts.
     * @param intervals
     * @return
     */
    public static boolean canAttendMeetings2(int[][] intervals) {
        Comparator<int[]> c=(int[] a, int[] b) -> (a[0]-b[0]);
        Arrays.sort(intervals, c);
        for(int i=0; i<intervals.length-1; i++)
            if(intervals[i][1]>intervals[i+1][0]) return false;
        return true;
}


    public static void main(String[] args) {
        int[][] ints = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(ints));
        System.out.println(canAttendMeetings2(ints));
    }

}
