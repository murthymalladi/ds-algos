package stringAlgorithms;

/**
 * Created by dmalladi on 10/11/2018.
 */
public class Palindrome {

    public static void main(String[] args) {
        String str = "aaabcaaa";
        if (palindrome(str)) {
            System.out.println("palindrome");
        }
        else {
            System.out.println("not a palindrome");
        }
    }

    public static boolean palindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while(i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
