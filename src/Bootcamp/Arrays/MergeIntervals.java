package Bootcamp.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals==null || intervals.size()==0){
            return result;
        }

        Comparator<Interval> comp = Comparator.comparing((Interval i)->i.start);
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

}

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
  }
