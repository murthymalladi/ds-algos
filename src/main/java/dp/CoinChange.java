package dp;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each
 * of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins
 * doesn’t matter.
 For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions:
 {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = 4;
        //int numWays = coinChangeRecursive(n,arr,arr.length);
        int numWays = coinChangeDP(arr,n);
        System.out.println(numWays);
    }

    public static int coinChangeRecursive(int n,int[] s,int m) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (m <= 0)
            return 0;

        return coinChangeRecursive(n,s,m-1) + coinChangeRecursive(n-s[m-1],s,m);
    }

    public static int coinChangeDP(int[] arr,int n) {
        int[][] sol = new int[arr.length+1][n+1];

        //base cases
        for (int i = 0; i <= arr.length; i++) {
            sol[i][0] = 1;
        }

        for (int i = 1; i <=n ; i++)
            sol[0][i] = 0;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= n ; j++) {
                sol[i][j] = sol[i-1][j];
                if (j - arr[i-1] >= 0)
                    sol[i][j] += sol[i][j-arr[i-1]];
            }
        }

        return sol[arr.length][n];

    }
}
