package dp;

/**
 * Created by dmalladi on 8/13/2019.
 */
public class PalindromeSubsequenceOfLengthK {

    public static void main(String[] args) {
        String s = "aabab";
        int k = 2;
        int len = lengthKDP(s,k);
        System.out.println(len);
    }

    public static int lengthKDP(String s,int k) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int[][][] dp = new int[n][n][k+1];
        for (int i = 0; i < n; i++) {
            if (k == 1)
                dp[i][i][k] = 1;
        }

        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                if (k == 2) {
                    dp[i][i+1][k] = 1;
                }
            }
        }

        for (int dist = 3; dist <= n; dist++) {
            for (int i = 0; i <= n-dist; i++) {
                int j = i+ dist - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j][k] =  dp[i+1][j-1][k-1] + dp[i][j-1][k] + dp[i+1][j][k] - dp[i+1][j-1][k];
                }
                else {
                    dp[i][j][k] = dp[i][j-1][k] + dp[i+1][j][k] - dp[i+1][j-1][k];
                }
            }
        }
        return dp[0][n-1][k];
    }
}
