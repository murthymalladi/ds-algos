package arrays;

/**
 * Created by dmalladi on 12/1/2018.
 */
public class GivenSumSubArray {

    public static void main(String[] args) {
        int[] arr = {10,-3,11};
        int sum = 8;
        int count = subArrayCountWithGivenSum(arr,sum);
        System.out.println(count);
    }
    public static int subArrayCountWithGivenSum(int[] arr,int sum) {
        int total = 0;
        int start = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
            while(start < arr.length && total > sum) {
                total = total - arr[start];
                start++;
            }
            if (total == sum) {
                count++;
            }
        }
        return count;
    }

}
