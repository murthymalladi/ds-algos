package sequence;

/**
 * Created by dmalladi on 11/18/2018.
 */
public class LongestUncommonSubSequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int len = lucs(s1,s2);

        System.out.println(len);
    }

    public static int lucs(String s1,String s2) {
        if (s1.equals(s2))
            return -1;
        return Math.max(s1.length(),s2.length());
    }


}
