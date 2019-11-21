package Bootcamp.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * To Rememember : only important step is to sort by start and then compare and rearrange.
 *
 * If we sort the intervals by their start value, then each set of intervals that can be merged will appear as a contiguous "run" in the sorted list.
 *
 * Time complexity : O(nlogn)
 *
 * Other than the sort invocation, we do a simple linear scan of the list, so the runtime is dominated by the O(nlgn)complexity of sorting.
 *
 * Space complexity : O(1) or O(n)
 *
 * If we can sort intervals in place, we do not need more than constant additional space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 *
 * here are the questions that can be solved with the same technique
 *
 * 252 Meeting Rooms
 * 253 Meeting Rooms II
 * 435 Non-overlapping Intervals <- very similar, i did it with just 3 lines different
 * https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
 */
public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals==null || intervals.size()==0){
            return result;
        }

        Comparator<Interval> comp = Comparator.comparing((Interval i)->i.start); // sorts intervals by start
        Collections.sort(intervals, comp);

        Interval temp = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if (temp.end>=curr.start){
                temp.end = Math.max(curr.end, temp.end);
            }else{
                result.add(temp);
                temp = curr;
            }
        }

        result.add(temp);

        return result;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15,18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval2);
        intervals.add(interval1);
        intervals.add(interval3);
        intervals.add(interval4);
        List<Interval> result = merge(intervals);
    }

}

class Interval {
     int start;
     int end;
     Interval(int s, int e) { start = s; end = e; }
  }


  /*
  class Solution {
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1)
			return intervals;

		// Sort by ascending starting point
		Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

		List<int[]> result = new ArrayList<>();
		int[] newInterval = intervals[0];
		result.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else {                             // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				result.add(newInterval);
			}
		}

		return result.toArray(new int[result.size()][]);
	}
}
   */