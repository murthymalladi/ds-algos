package dp;

/**
 * Created by dmalladi on 8/10/2019.
 */
public class IsSubsequence {

    public static void main(String[] args) {

        String s = "ace";
        String t = "abcdf";

        if (isSubsequence(s.toCharArray(),s.length(),t.toCharArray(),t.length())) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }

        if (isSubsequenceDP(s.toCharArray(),t.toCharArray())) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }

        if (isSub(s.toCharArray(),t.toCharArray())) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }

    public static boolean isSubsequence(char[] s,int m,char[] t,int n) {
        if (n == 0 && m != 0)
            return false;
        if (m == 0)
            return true;
        if (s[m-1] == t[n-1])
            return isSubsequence(s,m-1,t,n-1);
        return isSubsequence(s,m,t,n-1);
    }

    public static boolean isSubsequenceDP(char[] s,char[] t) {
        int m = s.length;
        int n = t.length;
        int[][] dp = new int[n+1][m+1];

        //base cases
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= m; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<= m; j++) {
                if (t[i-1] == s[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m] == 1;
    }

    //method 2 O(n)
    public static boolean isSub(char[] s, char[] t) {
        if (s.length == 0)
            return true;
        if (t.length == 0)
            return false;

        int index = 0;

        for (char c : s) {
            index = search(t,index,c);
            if (index == -1)
                return false;
            index = index + 1;
        }
        return true;
    }

    public static int search(char[] t,int index,char c) {

        for (int i = index; i< t.length; i++)
            if (t[i] == c)
                return i;

        return -1;
    }
}
