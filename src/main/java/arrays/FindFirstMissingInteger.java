package arrays;

import java.util.HashSet;

/**
 * Created by dmalladi on 11/4/2018.
 */
public class FindFirstMissingInteger {

    public static void main(String[] args) {
        int[] arr = {1,2,0};
        int output = findFirstMissingInteger(arr);
        System.out.println(output);
    }

    public static int findFirstMissingInteger(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int smallestPositive = 1;
        while(set.contains(smallestPositive)) {
            smallestPositive++;
        }
        return smallestPositive;
    }
}
