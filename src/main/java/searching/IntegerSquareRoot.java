package searching;

/**
 * Created by dmalladi on 10/16/2018.
 */
public class IntegerSquareRoot {

    public static void main(String[] args) {
        int input = 403;
        int sqrt = squareRoot(input);
        System.out.println(sqrt);
    }

    public static int squareRoot(int input) {
        int start = 0;
        int end = 65536;

        while(start+1 < end) {
            int mid = start + (end - start)/2;
            int mid_sqrt = mid * mid;
            if (mid_sqrt == input) {
                return mid;
            }
            else if (mid_sqrt > input) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return start;
    }
}
