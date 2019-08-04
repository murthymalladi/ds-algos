package dp;

/**
 * Created by dmalladi on 7/8/2019.
 */
public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        //boolean isTrue = isSubSetRecursive(arr,arr.length,sum);
        boolean isTrue = isSubSetDP(arr,sum);
        if (isTrue) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

        System.out.println("print all with recursive");
        printRecursive(arr,sum);
    }

    public static boolean isSubSetRecursive(int[] arr,int n,int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        return isSubSetRecursive(arr,n-1,sum) || isSubSetRecursive(arr,n-1,sum-arr[n-1]);
    }

    public static void printSubSetsRecusrsiveUtil(int[] arr,int index,int currSum,int sum,int[] sol) {
        if (currSum == sum) {
            for (int i = 0; i < sol.length; i++) {
                if (sol[i] == 1) {
                    System.out.print(arr[i] +" ");
                }
            }
            System.out.println();
        }
        else if (index == arr.length)
            return;
        else {
            sol[index] = 1; // add element to the set
            currSum = currSum + arr[index];
            printSubSetsRecusrsiveUtil(arr,index+1,currSum,sum,sol);
            sol[index] = 0; // doesn't add element to the set
            currSum = currSum - arr[index];
            printSubSetsRecusrsiveUtil(arr,index+1,currSum,sum,sol);
        }
    }

    public static void printRecursive(int[] arr,int sum) {
        int[] sol = new int[arr.length];
        printSubSetsRecusrsiveUtil(arr,0,0,sum,sol);
    }

    public static boolean isSubSetDP(int[] arr,int sum) {
        int m = arr.length;
        boolean[][] dp = new boolean[m+1][sum+1];
        for (int i = 0; i <=m;i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int  i = 1; i <= m ; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - arr[i-1] >= 0)
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
            }
        }
        return dp[m][sum];
    }
}
