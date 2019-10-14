package Bootcamp.Arrays;


import java.util.Arrays;

/**
 * Chronological Ordering
 * Same as meeting room 1 but different check in for loop.
 *
 * Algorithm
 *
 * Separate out the start times and the end times in their separate arrays.
 * Sort the start times and the end times separately. Note that this will mess up the original correspondence of start times and end times. They will be treated individually now.
 * We consider two pointers: s_ptr and e_ptr which refer to start pointer and end pointer. The start pointer simply iterates over all the meetings and the end pointer helps us track if a meeting has ended and if we can reuse a room.
 * When considering a specific meeting pointed to by s_ptr, we check if this start timing is greater than the meeting pointed to by e_ptr. If this is the case then that would mean some meeting has ended by the time the meeting at s_ptr had to start. So we can reuse one of the rooms. Otherwise, we have to allocate a new room.
 * If a meeting has indeed ended i.e. if start[s_ptr] >= end[e_ptr], then we increment e_ptr.
 * Repeat this process until s_ptr processes all of the meetings.
 *
 * Time Complexity: O(NlogN) because all we are doing is sorting the two arrays for start timings and end timings individually and each of them would contain NN elements considering there are NN intervals.
 *
 * Space Complexity: O(N) because we create two separate arrays of size NN, one for recording the start times and one for the end times.
 */
public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        int[] left = new int[intervals.length];
        int[] right = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            left[i] = intervals[i][0];
            right[i] = intervals[i][1];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<left.length; i++) {
            if(left[i]<right[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(ints));
    }
}
