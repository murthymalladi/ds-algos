package dp;

/**
 * Created by dmalladi on 8/4/2019.
 */
public class KnapSackProblem {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] w = {10, 20, 30};
        int W = 50;
        int maxVal = knapSackRecursive(val,w,val.length,W);
        System.out.println(maxVal);
        maxVal = knapSackDP(val,w,W);
        System.out.println(maxVal);
    }

    public static int knapSackRecursive(int[] val,int[] w,int n,int W) {
        if (n == 0 || W == 0)
            return 0;

        if (w[n-1] > W)
            return knapSackRecursive(val,w,n-1,W);
        return Math.max(val[n-1] + knapSackRecursive(val,w,n-1,W-w[n-1]),
                knapSackRecursive(val,w,n-1,W));
    }

    public static int knapSackDP(int[] val,int[] w,int W) {
        int n = val.length;
        int[][] dp = new int[W+1][n+1];

        //base case
        for (int i = 0; i <= W; i++)
            dp[i][0] = 0;

        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= n; j++) {

                if (w[j-1] > i) {
                    dp[i][j] = dp[i][j-1];
                }
                else {
                    dp[i][j] = Math.max(val[j-1] + dp[i-w[j-1]][j-1],
                            dp[i][j-1]);
                }
            }
        }
        return dp[W][n];
    }
}
