package dp;

/**
 * Created by dmalladi on 7/20/2019.
 */
public class CuttingRod {

    public static void main(String[] args) {
        int price[] = {3, 5, 8, 9, 10, 17, 17, 20};
        int max = maxValRecur(price,price.length);
        System.out.println(max);
        int maxdp = maxValDP(price);
        System.out.println(maxdp);
    }

    public static int maxValRecur(int[] price,int n) {
        if (n <= 0)
            return 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal,price[i] + maxValRecur(price,n-i-1));
        }
        return maxVal;
    }

    public static int maxValDP(int[] price) {
        int len = price.length;
        int[] dp = new int[len+1];
        dp[0] = 0;

        for (int i = 1; i <= len; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max,price[j] + dp[i-j-1]);
            }
            dp[i] = max;
        }
        return dp[len];
    }
}
