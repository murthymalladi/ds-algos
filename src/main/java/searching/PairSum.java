package searching;

import java.util.HashSet;

/**
 * Created by dmalladi on 10/16/2018.
 */
public class PairSum {
    public static void main(String[] args) {
        int[] arr = {100,5,7,3,1,6,9,8,14,-90};
        int target = 10;
        pairSum(arr,target);
    }

    public static void pairSum(int[] arr,int target) {
        HashSet<Integer> set = new HashSet<Integer>();
        int second;
        for (int i = 0; i < arr.length; i++) {
            second = target - arr[i];
            if (set.contains(second)) {
                System.out.println("pairs: " + arr[i] +", " + second);
            }
            set.add(arr[i]);
        }
    }
}
