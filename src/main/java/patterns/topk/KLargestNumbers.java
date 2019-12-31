package patterns.topk;

import java.util.*;

/**
 * Created by dmalladi on 10/5/2019.
 */
public class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        // TODO: Write your code here
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

            public int compare(Integer i1,Integer i2) {
                return i1-i2;
            }
        });

        for (int i = 0; i < k; i++)
            pq.add(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
