package Bootcamp.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
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
