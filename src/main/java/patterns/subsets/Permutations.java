package patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by dmalladi on 9/25/2019.
 */
public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (Integer num : nums) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                List<Integer> oldPermut = queue.poll();

                for (int j = 0; j <= oldPermut.size(); j++) {
                    List<Integer> newPermut = new ArrayList<>(oldPermut);
                    newPermut.add(j,num);
                    if (newPermut.size() == nums.length) {
                        result.add(newPermut);
                    }
                    else {
                        queue.add(newPermut);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
