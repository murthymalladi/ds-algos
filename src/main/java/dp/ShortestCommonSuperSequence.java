package dp;

/**
 * Created by dmalladi on 8/13/2019.
 */
public class ShortestCommonSuperSequence {

    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "eke";

        String res = scsRecur(s1.toCharArray(),s2.toCharArray(),s1.length(),s2.length(),"");

        System.out.println(res);

        String res1 = scsDP(s1,s2);
        System.out.println(res1);
    }

    public static String scsRecur(char[] s1,char[] s2,int m,int n,String result) {
        if (m == 0) {
            String res = new String(s2);

            return res.substring(0,n)+result;
        }
        else if (n == 0) {
            String res = new String(s1);
            return res.substring(0,m)+result;
        }

        if (s1[m-1] == s2[n-1]) {
            result =  scsRecur(s1,s2,m-1,n-1,s1[m-1]+result);
            return result;
        }
        else {
            String result1 = scsRecur(s1,s2,m-1,n,s1[m-1]+result);
            String result2 = scsRecur(s1,s2,m,n-1,s2[n-1]+result);
            if (result1.length() > result2.length()) {
                return result2;
            }
            else {
                return result1;
            }
        }
    }

    public static String scsDP(String s1,String s2) {
        if (s1.length() == 0)
            return s2;
        if (s2.length() == 0)
            return s1;

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        String res = "";
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;

        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        //construct the string from dp table
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.insert(0,s1.charAt(i-1));
                i--;
                j--;
            }
            else if (dp[i][j-1] < dp[i-1][j]) {
                sb.insert(0,s2.charAt(j-1));
                j--;
            }
            else {
                sb.insert(0,s1.charAt(i-1));
                i--;
            }
        }

        while(i > 0) {
            sb.insert(0,s1.charAt(i-1));
            i--;
        }
        while(j > 0) {
            sb.insert(0,s2.charAt(j-1));
            j--;
        }
        return sb.toString();

    }
}
