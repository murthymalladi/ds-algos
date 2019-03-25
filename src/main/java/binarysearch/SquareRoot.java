package binarysearch;

/**
 * Created by dmalladi on 12/23/2018.
 */
public class SquareRoot {

    public static void main(String[] args) {
        int x = 18;
        int val = sqrt(x);
        System.out.println(val);
    }

    public static int sqrt(int x) {
        int start = 1;
        int end = x;
        while(start < end) {
            int mid = start + (end - start)/2;
            if (mid * mid > x) {
               end = mid - 1;
            }
            else {
                if ((mid+1)*(mid+1) > x)
                    return mid;
                start = mid+1;
            }
        }
        return start;
    }
}
