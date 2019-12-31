package patterns.slidingwindow;

/**
 * Created by dmalladi on 9/10/2019.
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5};
        int k = 2;
        int maxSum = findMaxSumSubArray(k,arr);
        System.out.println(maxSum);

        int[] arr1 = {2, 1, 5, 1, 3, 2};
        k = 3;
        maxSum = findMaxSumSubArray(k,arr1);
        System.out.println(maxSum);

    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        if (arr.length == 0 || k > arr.length)
            return -1;
        int wordStart = 0;
        int maxSum = Integer.MIN_VALUE;
        int wordSum = 0;

        for (int wordEnd = 0; wordEnd < arr.length; wordEnd++) {
            wordSum += arr[wordEnd];
            if (wordEnd >= k-1) {
                maxSum = Math.max(maxSum,wordSum);
                wordSum -= arr[wordStart];
                wordStart++;
            }
        }
        return maxSum;
    }
}
