package sequence;

/**
 * Created by dmalladi on 11/19/2018.
 */
public class LongestUncommonSubSequence2 {

    public static void main(String[] args) {
        String[] strs = {"abc","abc","abc","aa"};
        int val = findLUSlength(strs);
        System.out.println(val);
    }

    public static int findLUSlength(String[] strs) {
        //   Arrays.sort(strs);
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            while(j < strs.length) {
                if (i != j && isSubSequence(strs[i],strs[j]))
                    break;
                j++;
            }
            if ( j == strs.length) {
                res = Math.max(res,strs[i].length());
            }
        }
        return res;
    }

    public static boolean isSubSequence(String a,String b) {
        int  i = 0;
        int j = 0;

        while(i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;j++;
            }
            else {
                j++;
            }
        }
        if (i == a.length())
            return true;
        return false;
    }
}
