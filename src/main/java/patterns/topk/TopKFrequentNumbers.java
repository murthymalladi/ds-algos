package patterns.topk;

import java.util.*;

/**
 * Created by dmalladi on 10/5/2019.
 */
public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        // TODO: Write your code here
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);

        Queue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((e1,e2) -> e1.getValue()- e2.getValue());
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while(minHeap.size() > 0) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }

    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11,5 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
