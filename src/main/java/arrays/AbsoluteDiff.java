package arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given an array of n distinct elements and a number x, arrange array elements according to the absolute
 * difference with x, i. e., element having minimum difference comes first and so on.
 Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.

 Input : arr[] : x = 7, arr[] = {10, 5, 3, 9, 2}
 Output : arr[] = {5, 9, 10, 3, 2}
 */
public class AbsoluteDiff {

    public static void main(String[] args) {
        int arr[] = {10, 5, 3, 9 ,2};
        int x = 7;
        sortArrayWithAbsoluteDiff(arr,x);
    }

    private static void sortArrayWithAbsoluteDiff(int[] arr,int x) {

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(Math.abs(x - arr[i]))) {
                map.get(Math.abs(x - arr[i])).add(arr[i]);
            }
            else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(arr[i]);
                map.put(Math.abs(x - arr[i]), list);
            }
        }

        for ( Integer key : map.keySet() ) {
            ArrayList<Integer> list = map.get(key);

            for (Integer i : list) {
                System.out.print(i+" ");
            }
        }

    }
}
