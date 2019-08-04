package dp;

/**
 * Created by dmalladi on 7/22/2019.
 */
public class LongestRepeatingSubSequence {

    public static void main(String[] args) {
        String X = "aabb";
        int len = lcsRecur(X.toCharArray(),X.toCharArray(),X.length(),X.length());
        System.out.println(len);
        int len2 = lcsDP(X.toCharArray());
        System.out.println(len2);
    }

    public static int lcsRecur(char[] X,char[] Y,int m,int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1] && m != n)
            return 1 + lcsRecur(X,Y,m-1,n-1);
        return Math.max(lcsRecur(X,Y,m,n-1),lcsRecur(X,Y,m-1,n));
    }

    public static int lcsDP(char[] X) {
        int m = X.length;
        int n = X.length;
        int[][] dp = new int[m+1][n+1];

        //base case
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;

        for (int  i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i-1] == X[j-1] && i != j) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
