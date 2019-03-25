package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by dmalladi on 10/29/2018.
 */
public class KMaxElements {

    public static void main(String[] args) {
        int[] arr = {3,6,4,9,10,2,1,7,5,8};
        kLargestElements(arr,3);
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void kLargestElements(int[] arr,int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10,new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                if (o1.equals(o2)) return 0;
                else return -1;
            }
        });

        for (int i = 0; i < k; i++)
            queue.offer(arr[i]);

        for (int i = k; i < arr.length; i++) {
            int top = queue.peek();
            if (arr[i] > top) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for(int i = 0; i < k; i++) {
            System.out.print(queue.poll()+" ");
        }
    }
}
