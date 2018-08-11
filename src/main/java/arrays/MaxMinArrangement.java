package arrays;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a sorted array of positive integers, rearrange the array alternately i.e first element
 * should be the maximum value, second minimum value, third-second max, fourth-second min and so on.
 */
public class MaxMinArrangement {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6,7,8,9,10};

        maxMinArrange(arr);
        printArray(arr);

    }
    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static void maxMinArrange(int[] arr) {
        Queue<Integer> queue = new LinkedList<Integer>();

        int start = 0;
        int end = arr.length - 1;
        int value = -1;
        while(start < end) {
            queue.offer(arr[start]);
            arr[start] = arr[end];
            end = end -1;
            start = start + 1;
            if (start < end)
              queue.offer(arr[start]);
            else if (start == end)
                value = arr[start];
            arr[start] = queue.poll();
            start = start + 1;

        }
     //   start = start + 1;
        if (start == end)
            start = start + 1;
        if (value != -1) {
            arr[start] = value;
            start = start + 1;
        }

        while(start < arr.length) {
            arr[start] = queue.poll();
            start = start + 1;
        }
    }
}
