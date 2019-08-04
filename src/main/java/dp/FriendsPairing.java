package dp;

/**
 * Created by dmalladi on 7/7/2019.
 */
public class FriendsPairing {

    public static void main(String[] args) {
        int n = 3;
       // int numWays = numWaysRecursive(n);
        int numWays = dp(n);
        System.out.println(numWays);
    }

    public static int numWaysRecursive(int n) {
        if (n == 0 || n == 1 || n == 2)
            return n;

        return numWaysRecursive(n-1) + (n-1)*numWaysRecursive(n-2);
    }

    public static int dp(int n) {
        int[] sol = new int[n+1];
        sol[0] = 0;
        sol[1] = 1;
        sol[2] = 2;

        for (int i = 3; i <= n; i++) {
            sol[i] = sol[i - 1] + (i - 1) * sol[i - 2];
        }

        return sol[n];
    }
}
