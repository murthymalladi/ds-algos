package arrays;

/**
 * Created by dmalladi on 10/22/2018.
 */
public class MinSumsubArray {

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        int min = minSubArray(arr,target);
        System.out.println(min);
    }

    public static int minSubArray(int[] arr,int target) {
        if (arr==null || arr.length == 0) return 0;
        int currSum=0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum+arr[i];
            if (currSum >= target) {
                while(currSum - arr[start] >= target) {
                    currSum = currSum - arr[start];
                    start++;
                }
                min = Math.min(min,i-start+1);
            }
        }
        return min;
    }
}
