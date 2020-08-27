package InterviewPractice.Arrays;

import java.util.TreeMap;

/**
 * When booking a new event [start, end), count delta[start]++ and delta[end]--. When processing the values of delta in sorted order of their keys,
 * the running sum active is the number of events open at that time. If the sum is 3 or more, that time is (at least) triple booked.
 *
 * 0 = {TreeMap$Entry@590} "5" -> "1"
 * 1 = {TreeMap$Entry@515} "10" -> "2"
 * 2 = {TreeMap$Entry@593} "15" -> "-1"
 * 3 = {TreeMap$Entry@516} "20" -> "-1"
 * 4 = {TreeMap$Entry@564} "40" -> "-1"
 * 5 = {TreeMap$Entry@537} "50" -> "1"
 * 6 = {TreeMap$Entry@540} "60" -> "-1"
 *
 * Time Complexity: O(N^2), where N is the number of events booked. For each new event, we traverse delta in O(N) time.
 *
 * Space Complexity: O(N), the size of delta.
 *
 */
public class MyCalendarII {
    static TreeMap<Integer, Integer> delta;
    public MyCalendarII() {
        delta = new TreeMap();
    }

    public static boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d: delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1); // reverting because its tripple booked
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII myCalendarII = new MyCalendarII();
        System.out.println(MyCalendarII.book(10,20));
        System.out.println(MyCalendarII.book(50, 60));
        System.out.println(MyCalendarII.book(10, 40));
        System.out.println(MyCalendarII.book(5, 15));
    }


}
