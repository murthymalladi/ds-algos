package slidingWindow;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by dmalladi on 5/26/2019.
 */
public class MedianSlidingWindow {

    public static void main(String[] args) {

        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] res = medianSlidingWindow(input,k);
        print(res);
    }

    public static void print(double[] res) {
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i]+" ");
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        MinMaxQueue queue = new MinMaxQueue();
        int n = nums.length;
        double[] res = new double[n-k+1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            queue.offer(nums[i]);
            if ( queue.size() == k) {
                res[index++] = queue.getMedian();
                queue.remove(nums[i-k+1]);
            }
        }
        return res;
    }



}

class MinMaxQueue {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    MinMaxQueue(){}

    public void offer(int val) {
        max.offer(val);
        min.offer(max.poll());

        //balance
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public double getMedian() {
        if (max.size() > min.size())
            return (double)(int)max.peek();
        else {
            return ((double)(int)max.peek() + (double)(int)min.peek())/2.0;
        }
    }

    public int size() {
        return max.size() + min.size();
    }

    public boolean remove(int val) {
        return max.remove(val) || min.remove(val);
    }
}
