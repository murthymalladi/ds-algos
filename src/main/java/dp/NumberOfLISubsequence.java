package dp;

import java.util.Arrays;

/**
 * Created by dmalladi on 7/25/2019.
 */
public class NumberOfLISubsequence {
    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7};
        int numOfLis = numOfLIS(arr);
        System.out.println(numOfLis);
    }

    public static int numOfLIS(int[] arr) {
        int n = arr.length;
        int[] length = new int[n];
        int[] count = new int[n];
        Arrays.fill(count,1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
//                if (arr[i] > arr[j] && length[i] < length[j] + 1) {
//                    length[i] = length[j] + 1;
//                    count[i] = count[j];
//                }
//                if (arr[i] > arr[j] && length[i] == length[j] + 1) {
//                    count[i] += count[j];
//                }

                if (arr[i] > arr[j]) {
                    if (length[j] >= length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                    else if (length[i] == length[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int len = 0, ans = 0;
        for (int i = 0; i < n; i++)
            len = Math.max(len,length[i]);

        for (int i = 0; i < n; i++) {
            if (length[i] == len)
                ans = ans + count[i];
        }
        return ans;
    }
}
