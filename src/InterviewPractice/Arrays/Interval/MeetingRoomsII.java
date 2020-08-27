package InterviewPractice.Arrays.Interval;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Chronological Ordering
 * Same as meeting room 1 but different check in for loop.
 *
 * Algorithm
 *
 * Separate out the start times and the end times in their separate arrays.
 * Sort the start times and the end times separately. Note that this will mess up the original correspondence of start times and end times. They will be treated individually now.
 * We consider two pointers: s_ptr and e_ptr which refer to start pointer and end pointer.
 * The start pointer simply iterates over all the meetings and the end pointer helps us track if a meeting has ended and if we can reuse a room.
 * When considering a specific meeting pointed to by s_ptr, we check if this start timing is greater than the meeting pointed to by e_ptr.
 * If this is the case then that would mean some meeting has ended by the time the meeting at s_ptr had to start. So we can reuse one of the rooms. Otherwise, we have to allocate a new room.
 * If a meeting has indeed ended i.e. if start[s_ptr] >= end[e_ptr], then we increment e_ptr.
 * Repeat this process until s_ptr processes all of the meetings.
 *
 * Time Complexity: O(NlogN) because all we are doing is sorting the two arrays for start timings and end timings individually and each of them would contain NN elements considering there are NN intervals.
 *
 * Space Complexity: O(N) because we create two separate arrays of size NN, one for recording the start times and one for the end times.
 *
 * 2nd option :
 * Sort the given meetings by their start time.
 * Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of the ending times as that tells us when a meeting room will get free.
 * For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or not.
 * If the room is free, then we extract the topmost element and add it back with the ending time of the current meeting we are processing.
 * If not, then we allocate a new room and add it to the heap.
 * After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will be the minimum number of rooms needed to accommodate all the meetings.
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

    public static int minMeetingRooms(Interval[] intervals) {

    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }

    // Min heap
    PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, Comparator.comparingInt(a -> a));

    // Sort the intervals by start time
    Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

    // Add the first meeting
    allocator.add(intervals[0].end);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {

      // If the room due to free up the earliest is free, assign that room to this meeting.
      if (intervals[i].start >= allocator.peek()) {
        allocator.poll();
      }

      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      allocator.add(intervals[i].end);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size();
  }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(ints));
    }
}
