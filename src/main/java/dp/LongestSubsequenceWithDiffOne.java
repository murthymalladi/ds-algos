package dp;

import java.util.Arrays;

/**
 * Created by dmalladi on 7/27/2019.
 */
public class LongestSubsequenceWithDiffOne {

    public static void main(String[] args) {
        int[] arr = {10, 9, 4, 5, 4, 8, 6};
        int len = maxSequence(arr);
        System.out.println(len);
    }

    public static int maxSequence(int[] arr) {
          int n = arr.length;
          int[] dp = new int[n];
           Arrays.fill(dp,1);
          for (int i = 1; i < n; i++) {
              for (int j = 0; j < i; j++) {

                  if ((arr[j] == arr[i] + 1 || arr[j] == arr[i] - 1) && dp[i] < dp[j] + 1) {
                     dp[i] = dp[j] + 1;
                  }
              }
          }
          return dp[n-1];
    }
}
