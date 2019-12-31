package arrays;

/**
 * Created by dmalladi on 12/28/2019.
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int sum = 0;
        int carry = 1;
        for (int i = n-1; i >= 0; i--) {
            sum = digits[i] + carry;
            digits[i]=sum%10;
            carry = sum/10;
        }
        if (carry == 0) {
            return digits;
        }

        int[] res= new int[n+1];
        res[0] = carry;
        for (int i = 0; i < digits.length; i++)
            res[i+1] = digits[i];

        return res;

    }

    public static void main(String[] args) {
        int[] arr = {9,9,9,9};
        int[] res = plusOne(arr);
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i]);
    }
}
