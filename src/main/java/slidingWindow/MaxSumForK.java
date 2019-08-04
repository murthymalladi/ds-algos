package slidingWindow;

/**
 * Created by dmalladi on 3/27/2019.
 */
public class MaxSumForK {

    public static void main(String[] args) {
        int[] arr = {100,200,300,400,500};
        int max = maxSum2(arr,2);
        System.out.println(max);
    }
    //brute force method
    public static int maxSum(int[] arr,int k) {

        int currSum = 0;
        int maxSum = 0;
        int n = arr.length;
        for (int i = 0; i < n-k+1; i++) {
            currSum = 0;
            for (int j = 0; j < k; j++) {
                currSum += arr[i+j];
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    //sliding window
    public static int maxSum2(int[] arr,int k) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];

        for (int j = k; j < arr.length; j++) {
            sum += arr[j] - arr[j-k];
            if (sum > max)
                max = sum;
        }
        return max;
    }
}
