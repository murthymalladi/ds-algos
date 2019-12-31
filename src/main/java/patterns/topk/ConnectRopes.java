package patterns.topk;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dmalladi on 10/5/2019.
 */
public class ConnectRopes {
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        // TODO: Write your code here
        int minCost = 0;
        int sum = 0;
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < ropeLengths.length;i++)
            minHeap.add(ropeLengths[i]);
        sum = minHeap.poll();
        sum += minHeap.poll();
        minCost = sum;

        for (int i = 0; i < ropeLengths.length-2; i++) {
            int val = minHeap.poll();
            sum += val;
            minCost += sum;
        }

        return minCost;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
