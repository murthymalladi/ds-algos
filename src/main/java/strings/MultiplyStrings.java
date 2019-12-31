package strings;

/**
 * Created by dmalladi on 12/28/2019.
 */
public class MultiplyStrings {

    public static String stringMul(String num1,String num2) {
        int[] digits = new int[num1.length()+num2.length()-1];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                digits[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = digits.length-1; i > 0; i--) {
            int sum = carry + digits[i];
            int val = sum%10;
            carry = sum/10;
            digits[i] = val;
        }
        if (carry != 0) {
            digits[0] += carry;
        }
        for (int i = 0; i < digits.length;i++)
            sb.append(digits[i]);
        return sb.toString();
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] ans = new int[num1.length() + num2.length() - 1];

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "9133";
        String num2 = "0";
        String digits = multiply(num1,num2);

         System.out.print(digits);
    }
}
