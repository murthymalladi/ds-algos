package dp;

/**
 * Created by dmalladi on 11/8/2018.
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int paths = uniquePaths(m,n);
        System.out.println(paths);
    }

    public static int uniquePaths(int m,int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
