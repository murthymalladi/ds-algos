package patterns.topk;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dmalladi on 10/5/2019.
 */
public class KthSmallestNumber {

    public static int findKthSmallestNumber(int[] nums, int k) {
        // TODO: Write your code here
        //create a mx priority
        Queue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n2-n1);
        int count = 0;
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() > nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
