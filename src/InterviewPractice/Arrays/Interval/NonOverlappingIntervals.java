package InterviewPractice.Arrays.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;
        Comparator<Interval> comp = Comparator.comparing((Interval i)->i.end);
        Arrays.sort(intervals, comp);
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
}
