package dp;

import java.util.Arrays;

/**
 * Created by dmalladi on 8/10/2019.
 */
public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        int len = longestRecur(s.toCharArray(),0,s.length()-1);
        System.out.println(len);
        len = longestDP(s.toCharArray());
        System.out.println(len);
    }

    //recursive
    public static int longestRecur(char[] s,int start,int end) {
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        if (s[start] == s[end]) {
            return 2 + longestRecur(s,start+1,end-1);
        }
        else {
            return Math.max(longestRecur(s,start+1,end),longestRecur(s,start,end-1));
        }
    }

    // dp approach
    public static int longestDP(char[] s) {
        int n = s.length;
        int[][] dp = new int[n][n];


        //1. base case each sub sequence of length = 1 is a palindrome
        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                int j = i+k-1;
                if (s[i] == s[j] && k == 2)
                    dp[i][j] = 2;
                else if (s[i] == s[j])
                    dp[i][j] = 2 + dp[i+1][j-1];
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }


}
