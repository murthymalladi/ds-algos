package arrays;

import java.util.HashMap;


/**
 * Created by dmalladi on 12/30/2019.
 */
public class MaximizeDistance {
    public static int maxDistToClosest(int[] seats) {
        if (seats.length == 0)
            return 0;
        int mStart = 0;
        int mEnd = 0;
        int maxLen = Integer.MIN_VALUE;
        int s=0,e=0;

        int i = 0;

        while(i < seats.length) {

            if (seats[i] == 0) {
                s = i;
                while(i+1 < seats.length && seats[i] == seats[i+1])
                    i++;
                e = i;
                if (maxLen == e -s + 1) {
                    if (e == seats.length-1 || s == 0) {
                        mStart = s;
                        mEnd = e;
                    }
                }
                if (maxLen < e - s +1) {
                    maxLen = e - s +1;
                    mStart = s;
                    mEnd = e;
                }

            }
            i++;
        }

        if (maxLen == Integer.MIN_VALUE) return 0;
        else if (mStart == 0 || mEnd == seats.length-1) return maxLen;
        else if (maxLen%2 == 1) return (maxLen/2)+1;
        else return maxLen/2;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1};
        int max = maxDistToClosest(arr);
        System.out.println(max);

    }
}
