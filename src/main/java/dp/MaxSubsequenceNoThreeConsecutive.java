package dp;

/**
 * Created by dmalladi on 8/1/2019.
 */
public class MaxSubsequenceNoThreeConsecutive {

    public static void main(String[] args) {
        int[] arr = {3000, 2000, 1000, 3, 10};
        int mx = maxSequence(arr);
        System.out.println(mx);
    }

    public static int maxSequence(int[] arr) {
        int n = arr.length;
        int[] ms = new int[n];
        ms[0] = arr[0];
        ms[1] = arr[0] + arr[1];
        ms[2] = Math.max(Math.max(arr[1] + arr[2], arr[0] + arr[2]),ms[1]);

        for (int i = 3; i < n; i++) {
            ms[i] = Math.max(ms[i-1],Math.max(ms[i-2]+arr[i],
                    ms[i-3]+arr[i-1]+arr[i]));
        }
        return ms[n-1];
    }
}
