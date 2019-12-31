package dp;

import java.util.Arrays;

/**
 * Created by dmalladi on 8/4/2019.
 */
public class TempleOfferings {

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int[] arr1 = {1, 4, 3, 6, 2, 1};
        int sum = totalOfferings(arr);
        System.out.println(sum);
    }

    public static int totalOfferings(int[] temples) {
        int n = temples.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for (int i = 1; i < temples.length; i++) {
            if (temples[i] > temples[i-1]) {
                if (dp[i] <= dp[i-1])
                  dp[i] = dp[i-1] + 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (temples[i] > temples[i+1]) {
                if (dp[i] <= dp[i+1])
                  dp[i] = dp[i+1] + 1;
            }
        }

        int sum = 0;

        for (int i = 0; i < dp.length; i++)
            sum += dp[i];
        return sum;
    }
}
