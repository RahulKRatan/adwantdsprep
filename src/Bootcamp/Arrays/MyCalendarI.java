package Bootcamp.Arrays;

import java.util.TreeMap;

/**
 * For Java, we will have a TreeMap where the keys are the start of each interval, and the values are the ends of those intervals.
 * When inserting the interval [start, end), we check if there is a conflict on each side with neighboring intervals:
 * we would like calendar.get(prev)) <= start <= end <= next for the booking to be valid (or for prev or next to be null respectively.)
 *
 * Time Complexity (Java): (NlogN), where NN is the number of events booked. For each new event, we search that the event is legal in O(\log N)O(logN) time, then insert it in O(1)O(1) time.
 *
 aaa
 * Space Complexity: O(N), the size of the data structures used.
 */
public class MyCalendarI {
    TreeMap<Integer,Integer> booked;
    public MyCalendarI() {
        booked = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = booked.floorKey(start); // greatest key less than or equal to the given key
        Integer next = booked.ceilingKey(start); //  least key greater than or equal to the given key

        if((prev == null || booked.get(prev) <= start) && (next == null || end<= next)){
            booked.put(start,end);
            return true;
        }
        return false;
    }

}
