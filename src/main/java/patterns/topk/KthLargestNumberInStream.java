package patterns.topk;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dmalladi on 10/5/2019.
 */
public class KthLargestNumberInStream {

    Queue<Integer> minHeap;
    private int k;
    public KthLargestNumberInStream(int[] nums, int k) {
        minHeap = new PriorityQueue<>((n1,n2) -> n1-n2);
        for (int i = 0; i < nums.length; i++)
            minHeap.add(nums[i]);
        this.k = k;
    }

    public int add(int num) {

        minHeap.add(num);

        while(minHeap.size() > this.k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }
}
