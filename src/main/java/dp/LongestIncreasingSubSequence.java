package dp;

import java.util.Arrays;

/**
 * Created by dmalladi on 7/24/2019.
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int max = lisRecur(arr,Integer.MIN_VALUE,0);
        System.out.println(max);
        max = lisDP(arr);
        System.out.println(max);
    }

    public static int lisRecur(int[] arr,int prev,int curPosition) {
        if (curPosition == arr.length) {
            return 0;
        }

        int include = 0;
        if (arr[curPosition] > prev) {
            include = 1 + lisRecur(arr,arr[curPosition],curPosition+1);
        }
        int exclude = lisRecur(arr,prev,curPosition+1);
        int max = Math.max(include,exclude);
        return max;
    }

    public static int lisDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i < n; i++)
            max = Math.max(max,dp[i]);
        return max;
    }
}
