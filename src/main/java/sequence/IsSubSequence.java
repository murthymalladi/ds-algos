package sequence;

/**
 * Created by dmalladi on 11/19/2018.
 */
public class IsSubSequence {

    public static void main(String[] args) {
        String a = "abcde";
        String b = "abcdfghe";
        if (isSubSequence(a,b)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public static boolean isSubSequence(String a,String b) {
        int i = 0;
        int j = 0;

        while(i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;j++;
            }
            else {
                j++;
            }
        }
        if ( i == a.length())
            return true;
        return false;
    }
}
