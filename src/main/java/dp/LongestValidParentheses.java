package dp;

/**
 * Created by dmalladi on 5/26/2019.
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String str = "(())()((()))";
        int length = longestValidParentheses(str);
        System.out.println(length);

    }

    public static int longestValidParentheses(String str) {
        int n = str.length();
        int[] dp = new int[n];

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if ( str.charAt(i-1) == '(') {
                    dp[i] = i-2>= 0 ? dp[i-2] + 2:2;
                }
                else {
                    if (i-dp[i-1]-1>=0 && str.charAt(i-dp[i-1]-1) == '(') {
                        dp[i] = i-dp[i-1]-2>=0? dp[i-1]+2+dp[i-dp[i-1]-2]:dp[i-1]+2;
                    }
                }

            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++)
            max = Math.max(max,dp[i]);

        return max;
    }
}
