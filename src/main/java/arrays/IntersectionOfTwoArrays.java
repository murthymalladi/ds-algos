package arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dmalladi on 12/7/2018.
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        int[] b = {1,1};
        int[] res = intersect(a,b);
        for (int i = 0 ; i < res.length; i++)
            System.out.println(res[i] + " ");
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                res.add(nums2[i]);
                if (map.get(nums2[i]) > 1) {
                    map.put(nums2[i],map.get(nums2[i])-1);
                }
                else {
                    map.remove(nums2[i]);
                }
            }
        }

        int[] arr = new int[res.size()];

        for (int i = 0; i < res.size(); i++)
            arr[i] = res.get(i);

        return arr;
    }

}
