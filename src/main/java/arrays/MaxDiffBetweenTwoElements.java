package arrays;

/**
 * Created by dmalladi on 10/30/2018.
 */
public class MaxDiffBetweenTwoElements {
    public static void main(String[] args) {
        int[] arr = {3, 6, 4, 9, 10, 2, 0, 7, 5, 8};
        int maxDiff = maxDiff(arr);
        System.out.println(maxDiff);
    }

    public static int maxDiff(int[] arr) {
        int maxDiff = arr[1] - arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min > maxDiff) {
                maxDiff = arr[i] - min;
            }
            if (arr[i] < min)
                min = arr[i];
        }
        return maxDiff;
    }
}


