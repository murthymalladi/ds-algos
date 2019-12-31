package patterns.slidingwindow;

/**
 * Created by dmalladi on 9/12/2019.
 */
public class LongestSubArrayWithAllOnes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;
        int maxLen = findLengthV2(arr,k);
        System.out.println(maxLen);
    }

    public static int findLength(int[] arr, int k) {
        if (arr.length == 0)
            return -1;

        int start = 0;
        int count = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int end = 0; end < arr.length; end++) {

            if (arr[end] == 0) {
                count++;
            }

            if (count > k) {
                while(arr[start] != 0 && start < end)
                    start++;

                start = start+1;
                count--;
            }

            maxLen = Math.max(maxLen,end - start + 1);
        }

        if (maxLen == Integer.MIN_VALUE)
            return -1;
        return maxLen;
    }

    public static int findLengthV2(int[] arr, int k) {

        int start = 0;
        int maxLen = Integer.MIN_VALUE;
        int maxOneCount = 0;

        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1) {
                maxOneCount++;
            }

            if (end - start + 1 - maxOneCount > k) {
                if (arr[start] == 1)
                    maxOneCount--;
                start++;
            }
            maxLen = Math.max(maxLen,end - start + 1);
        }

        if (maxLen == Integer.MIN_VALUE)
            return -1;
        return maxLen;
    }

}
