package patterns.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dmalladi on 10/6/2019.
 */
public class MaximumDistinctElements {
    public static int findMaximumDistinctElements(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        Queue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((e1,e2) -> e1.getValue() - e2.getValue());

        int count = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
            else {
                minHeap.add(entry);
            }
        }
        while(k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer,Integer> entry = minHeap.poll();

            k = k - (entry.getValue()-1);
            if (k >= 0)
                count++;
        }
        if (k > 0)
            count = count - k;
        return count;
    }

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }
}
