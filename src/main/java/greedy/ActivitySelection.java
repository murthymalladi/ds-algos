package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmalladi on 9/23/2018.
 */
public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {3,5,0,1,5,8};
        int[] end   = {4,7,6,2,9,9};
        selectActivities(start,end);

    }
    static class Interval implements Comparable<Interval> {
        private int s;
        private int f;
        Interval(int start,int end) {
            this.s = start;
            this.f = end;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getF() {
            return f;
        }

        public void setF(int f) {
            this.f = f;
        }

        public int compareTo(Interval o) {
            return this.getF() - o.getF();
        }
    }
    public static void selectActivities(int[] start,int[] end) {
        List<Interval> intervals = new ArrayList<Interval>();

        Interval interval = null;

        for (int i = 0; i < start.length; i++) {
            interval = new Interval(start[i],end[i]);
            intervals.add(interval);
        }
        Collections.sort(intervals);
        List<Interval> selectedList = new ArrayList<Interval>();
        selectedList.add(intervals.get(0));
        Interval prev = intervals.get(0);
        Interval curr = null;
        for (int i = 1; i < intervals.size(); i++) {
            curr = intervals.get(i);
            if( (prev.getF() <= curr.getS())) {
                selectedList.add(curr);
                prev = curr;
            }
        }

        for (Interval item : selectedList) {
            System.out.println(item.getS() +" " + item.getF());
        }
    }
}
