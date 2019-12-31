package dp;

/**
 * Created by dmalladi on 7/21/2019.
 */
public class LongestCommonSequence {

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int maxLen = lcsRecur(X.toCharArray(),Y.toCharArray(),X.length(),Y.length());
        int max = lcsDP(X.toCharArray(),Y.toCharArray());
        System.out.println(maxLen);
        System.out.println(max);
        String lcs = printLCS(X.toCharArray(),Y.toCharArray());
        System.out.println(lcs);
    }

    public static int lcsRecur(char[] X,char[] Y, int m,int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcsRecur(X,Y,m-1,n-1);
        return Math.max(lcsRecur(X,Y,m,n-1),lcsRecur(X,Y,m-1,n));
    }

    public static int lcsDP(char[] X,char[] Y) {
        int m = X.length;
        int n = Y.length;

        int[][] dp = new int[m+1][n+1];
        //base case
        for (int i = 0; i <=m ;i++)
            dp[i][0] = 0;
        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (X[i-1] == Y[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String printLCS(char[] X,char[] Y) {
        int m = X.length;
        int n = Y.length;

        int[][] dp = new int[m+1][n+1];
        //base case
        for (int i = 0; i <=m ;i++)
            dp[i][0] = 0;
        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (X[i-1] == Y[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        //print the string
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();

        while(i > 0 && j > 0) {
            if (X[i-1] == Y[j-1]) {
                sb.insert(0,X[i-1]);
                i--;
                j--;
            }
            else if (dp[i][j-1] > dp[i-1][j]) {
                j--;
            }
            else {
                i--;
            }
        }
        return sb.toString();
    }
}
