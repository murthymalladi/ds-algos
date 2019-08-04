package validations;

/**
 * Created by dmalladi on 10/23/2018.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        if (isValidPalindromeV2(str)) {
            System.out.println("valid palindrome");
        }
        else {
            System.out.println("not a valid palindrome");
        }
    }

    public static boolean isValidPalindromeV2(String str) {
        int start = 0;
        int end = str.length()-1;

        while(start < end) {
            while(start < end && !Character.isLetterOrDigit(str.charAt(start)))
                start++;
            while(end >=0 && !Character.isLetterOrDigit(str.charAt(end)))
                end--;
            if (start < end && Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end)))
                return false;
            start++;end--;
        }
        return true;
    }

    public static boolean isValidPalindrome(String str) {
        if (str == null) return false;
        if (str.length() == 0) return true;
        int start = 0;
        int end = str.length() - 1;

        while(start < end) {
            while(start < str.length() - 1 && !isAlphabet(str.charAt(start)) && !isDigit(str.charAt(start)))
                start++;
            while(end > 0 && !isAlphabet(str.charAt(start)) && !isDigit(str.charAt(start)))
                end--;
            if (start > end)
                return false;
            if (!isSame(str.charAt(start),str.charAt(end)))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isSame(char a,char b) {
        if (isDigit(a) && isDigit(b))
            return a == b;
        if (Character.toLowerCase(a) == Character.toLowerCase(b))
            return true;
        return false;
    }

    public static boolean isAlphabet(char c) {
        if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') )
            return true;
        return false;
    }

    public static boolean isDigit(char c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }
}
