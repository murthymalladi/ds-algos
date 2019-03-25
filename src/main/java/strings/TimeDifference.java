package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dmalladi on 11/20/2018.
 */
public class TimeDifference {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("00:00");
        list.add("23:59");
        list.add("00:00");

        int min = findMinDifference(list);
        System.out.println(min);

    }

    public static int findMinDifference(List<String> timePoints) {
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String a,String b) {
                String[] t1 = a.split(":");
                String[] t2 = b.split(":");
                if (t1[0].equals("00")) {
                    t1[0] = "24";
                }
                if (t2[0].equals("00")) {
                    t2[0] = "24";
                }

                if (Integer.valueOf(t1[0]) > Integer.valueOf(t2[0]))
                    return 1;
                else if (Integer.valueOf(t1[0]) == Integer.valueOf(t2[0])) {
                    if (Integer.valueOf(t1[1]) > Integer.valueOf(t2[1]))
                        return 1;
                    else if (Integer.valueOf(t1[1]) == Integer.valueOf(t2[1]))
                        return 0;
                    else return -1;

                }
                else {
                    return -1;
                }
            }
        };

        Collections.sort(timePoints,comp);
        int min = Integer.MAX_VALUE;
        for (int i = timePoints.size()-2; i >=0; i--) {
            int val = difference(timePoints.get(i+1),timePoints.get(i));
            if (val < min) {
                min = val;
            }
        }
        int check = difference(timePoints.get(timePoints.size()-1),timePoints.get(0));

        return Math.min(min,check);
    }

    public static int difference(String big,String small) {
        String[] t1 = big.split(":");
        String[] t2 = small.split(":");

        int hDiff = (t1[0].equals("00") ? 24: Integer.valueOf(t1[0])) - (t2[0].equals("00") ? 24 : Integer.valueOf(t2[0]));
        int minDiff = Integer.valueOf(t1[1]) - Integer.valueOf(t2[1]);
        int diff = hDiff*60 + minDiff;
        int min = Math.min(diff,1440-diff);
        return min;

    }
}
