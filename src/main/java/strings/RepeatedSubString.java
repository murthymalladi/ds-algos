package strings;

/**
 * Created by dmalladi on 11/18/2018.
 */
public class RepeatedSubString {

    public static void main(String[] args) {
        String s = "abcabc";
        if (repeatedSubString(s)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public static boolean repeatedSubString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str);
        return sb.substring(1,sb.length()-1).contains(str);
    }

    
}
