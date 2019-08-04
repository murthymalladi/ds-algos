package dp;

import java.util.Arrays;

/**
 * Created by dmalladi on 7/25/2019.
 */
public class ProductLessThanKSequences {

    public static void main(String[] args) {
        int[] arr = {4, 8, 7, 2};
        int k = 50;
        int len = numberOfSequences(arr,k);
        System.out.println(len);
    }

    public static int numberOfSequences(int[] arr,int k) {
        int n = arr.length;
        int[][] dp = new int[k+1][n+1];
        for (int i = 0; i <=k; i++)
            Arrays.fill(dp[i],0);

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j<= n; j++) {
                dp[i][j] = dp[i][j-1];

                if (arr[j-1] <= i && arr[j-1] > 0) {
                    dp[i][j] += dp[i/arr[j-1]][j-1] + 1;
                }
            }
        }
        return dp[k][n];
    }
}
