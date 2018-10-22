package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dmalladi on 10/21/2018.
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists)
         System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = null;

        for (int k = 0; k < nums.length; k++) {
            if (k > 0 && nums[k] == nums[k-1])
                continue;
            int start = k+1;
            int end = nums.length - 1;
            while(start < end) {
              if (nums[k]+nums[start]+nums[end] == 0) {
                    list = Arrays.asList(nums[k],nums[start],nums[end]);
                    start++;end--;
                    result.add(list);
                    while (start < end  && nums[start] == nums[start-1]) start++;
                    while(start < end && nums[end] == nums[end+1]) end--;
               }
                else if (nums[k]+nums[start]+nums[end] < 0) {
                    start++;
                }
                else {
                    end--;
                }

            }//while loop end

        }
        return result;
    }
}
