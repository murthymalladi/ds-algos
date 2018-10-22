package maths;

/**
 * Created by dmalladi on 10/19/2018.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int n = 1231;
        if (palindrome(n)) {
            System.out.println("palindrome");
        }
        else {
            System.out.println("not a palindrome");
        }
    }

    public static boolean palindrome(int x) {
        int rev=0;
        int val = x;
        while(val > 0) {
            rev = rev*10+ val%10;
            val = val/10;
        }
        return rev == x;

    }
}
