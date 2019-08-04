package arrays;

/**
 * Created by dmalladi on 4/13/2019.
 */
public class MaxSumNonAdjacentElements {

    public static void main(String[] args) {
        int[] arr = {1,20,3};
        int max = maxSumNonAdjacentElements(arr);
        System.out.println(max);
    }

    public static int maxSumNonAdjacentElements(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        if (arr.length == 2)
            return Math.max(arr[0],arr[1]);

        int max1 = arr[0];
        int max2 = Math.max(arr[0],arr[1]);
        int currMax = 0;
        for (int i = 2 ; i < arr.length; i++) {
            currMax = Math.max(arr[i]+max1,max2);
            max1 = max2;
            max2 = currMax;
        }
        return currMax;
    }
}
