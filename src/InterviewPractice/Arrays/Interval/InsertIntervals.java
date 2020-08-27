package InterviewPractice.Arrays.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * ___: current interval(i); _ _ _: newInterval
 *
 * 1) i.end < newInterval.start，then we can safely add i to result;
 * 	newInterval still needs to be compared with latter intervals
 *
 * 	|________|
 * 			       |_ _ _ _ _|
 *
 * 2) i.start > newInterval.end，then we can safely add both to result，
 * 	and mark newInterval as null
 *
 * 			       |________|
 * 	|_ _ _ _ _|
 *
 * 3) There is overlap between i and newInterval. We can merge i into newInterval,
 * then use the updated newInterval to compare with latter intervals.
 *
 *
 * 	|________|
 * 		|_ _ _ _ _|
 *
 * 		|________|
 * 	|_ _ _ _ _|
 */
public class InsertIntervals {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        for (Interval i : intervals) {

            if (newInterval == null || i.end < newInterval.start)
                result.add(i);

            else if (i.start > newInterval.end) {
                //careful about sequence here
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            }

            else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }

        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }
}

/*
 public int[][] insert(int[][] intervals, int[] newInterval) {

         List<int[]> result = new ArrayList<>();

         for(int[] i : intervals){
             if(newInterval == null || i[1] < newInterval[0]){
                 result.add(i);
             }else if(i[0] > newInterval[1]){
                // be careful the sequence here
                 result.add(newInterval);
                 result.add(i);
                 newInterval = null;
             }else{

                 newInterval[0] = Math.min(newInterval[0], i[0]);//get min
                 newInterval[1] = Math.max(newInterval[1], i[1]);//get max
             }
         }

        if(newInterval != null)
            result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
 */
