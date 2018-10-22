package maths;

/**
 * Created by dmalladi on 10/18/2018.
 */
public class ReverseNumber {
    public static void main(String[] args) {
        int number = -123;
        int rev = reverse(number);
        System.out.println(rev);
    }
    public static int reverse(int number) {

        int rev = 0;
        int res;
        int tail;
        while(number != 0) {
            tail = number%10;
            res = rev*10 + tail;
            if  ( (res - tail)/10 != rev )
                return 0;

            number = number/10;
            rev = res;
        }

        return rev;
    }
}
