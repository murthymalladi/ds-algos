package stringAlgorithms;

/**
 * Created by dmalladi on 10/17/2018.
 */
public class PatternMatch {
    public static void main(String[] args) {
        String s = "aab";
        String p = "a*";
        if (isMatch(s,p)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public static boolean isMatch(String s,String p) {
        if (p.length() == 0) return s.length() == 0;
        boolean firstChar =  (s.length() != 0) && ( ( p.charAt(0) == s.charAt(0) ) || p.charAt(0) == '.' );

        if (p.length() > 1 && p.charAt(1) == '*') {
            return (firstChar && isMatch(s.substring(1),p) ) || isMatch(s,p.substring(2));
        }
        else {
            return firstChar && isMatch(s.substring(1),p.substring(1));
        }

    }
}
