package patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by dmalladi on 9/22/2019.
 */
public class SubsetsWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        Arrays.sort(nums);
        subsets.add(new ArrayList<>());
        int start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            if (i > 0 && nums[i] == nums[i-1]) {
                start = end;
            }
            end = subsets.size();
            for (int j = start; j < end; j++) {
                List<Integer> list = new ArrayList<>(subsets.get(j));
                list.add(nums[i]);
                subsets.add(list);

            }

        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetsWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
