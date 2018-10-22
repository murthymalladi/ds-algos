package arrays;

import java.util.HashMap;

/**
 * Created by dmalladi on 10/11/2018.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(arr,target);

        for (int i = 0; i < res.length; i++)
         System.out.println(res[i]+" ");

    }

    public static int[] twoSum(int[] arr,int target) {
        if (arr == null || arr.length < 2)
            return new int[] {0,0};
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int[]{map.get(arr[i]),i};
            }
            else {
                map.put(target - arr[i],i);
            }
        }
        return new int[]{0,0};
    }
}
