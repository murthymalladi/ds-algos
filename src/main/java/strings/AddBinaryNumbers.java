package strings;

/**
 * Created by dmalladi on 10/24/2018.
 */
public class AddBinaryNumbers {

    public static void main(String[] args) {
        String s1 = "1010";
        String s2 = "1011";
        String sum = binarySum(s1,s2);
        System.out.println(sum);
    }

    public static String binarySum(String s1,String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(j) - '0';
            int c = a+b+ carry;
            if (c == 2) {
                carry = 1;
                c = 0;
            }
            else if (c ==3) {
                carry = 1;
                c = 1;
            }
            else {
                carry = 0;
            }
            sb.insert(0,String.valueOf(c));
            i--;j--;
        }
        while (i >= 0) {
            int a = s1.charAt(i) - '0';
            int c = a + carry;
            if (c == 2) {
                carry = 1;
                c = 0;
            }
            else {
                carry = 0;
            }
            sb.insert(0,String.valueOf(c));
            i--;
        }

        while (j >= 0) {
            int b = s2.charAt(j) - '0';
            int c = b + carry;
            if (c == 2) {
                carry = 1;
                c = 0;
            }
            else {
                carry = 0;
            }
            sb.insert(0,String.valueOf(c));
            j--;
        }
        if (carry == 1)
            sb.insert(0,carry);
        return sb.toString();
    }
}
