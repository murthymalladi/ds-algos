package arrays;

import java.util.*;

/**
 * Created by dmalladi on 10/23/2018.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int length = lcs(nums);
        System.out.println(length);
    }

    public static int lcs(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0 ;i < nums.length; i++)
            set.add(nums[i]);
        int max = 0;

        int count = 1;
        Collection<Integer> removeCandidates  = null;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("iteration: "+i);
            count = 1;
            removeCandidates = new LinkedList<Integer>();
            if (set.contains(nums[i])) {
                removeCandidates.add(nums[i]);
                int left = nums[i]-1;
                int right = nums[i]+1;
                while (set.contains(left)) {
                    removeCandidates.add(left);
                    count = count+1;
                    left = left - 1;
                }
                while(set.contains(right)) {
                    removeCandidates.add(right);
                    count = count + 1;
                    right = right + 1;
                }
                if (count > max) {
                    max = count;

                }
                set.removeAll(removeCandidates);
                if (set.size() == 0)
                    break;
            }
        }
        return max;
    }
}
