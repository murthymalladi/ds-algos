package patterns.mergeintervals;

import java.util.*;

/**
 * Created by dmalladi on 9/18/2019.
 */

//class Interval {
//    int start;
//    int end;
//
//    public Interval(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//}
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        // TODO: Write your code here
        Comparator<Interval> mycomp = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1,Interval i2) {
                return i1.start - i2.start;
            }
        };

        Collections.sort(intervals,mycomp);
        int size = 0;
        mergedIntervals.add(intervals.get(0));
        size = mergedIntervals.size();
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            Interval prevInterval = mergedIntervals.get(size-1);

            if (prevInterval.end > interval.start) {
                if (prevInterval.end < interval.end) {
                    Interval inter = new Interval(prevInterval.start,interval.end);
                    mergedIntervals.remove(size-1);
                    mergedIntervals.add(inter);
                    size = mergedIntervals.size();
                }
            }
            else {
                mergedIntervals.add(interval);
                size = mergedIntervals.size();
            }

        }

        return mergedIntervals;
    }
}
