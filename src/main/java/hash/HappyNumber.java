package hash;

import java.util.HashSet;

/**
 * Created by dmalladi on 12/6/2018.
 */
public class HappyNumber {

    public static void main(String[] args) {
        int number = 20;
        if (isHappyNumber(number)) {
            System.out.println("Happy number");
        }
        else {
            System.out.println("not a Happy number");
        }
    }

    public static boolean isHappyNumber(int number) {
        HashSet<Integer> hashSet = new HashSet<Integer>();

        while(true) {
            number = digitSquareNumber(number);
            if (number == 1)
                return true;
            if (hashSet.contains(number))
                return false;
            hashSet.add(number);
        }
    }

    public static int digitSquareNumber(int number) {
        int sum = 0;
        int digit = 0;

        while(number != 0) {
            digit = number%10;
            sum = sum + digit*digit;
            number = number/10;
        }
        return sum;
    }
}
