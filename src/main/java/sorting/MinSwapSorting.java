package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dmalladi
 */
public class MinSwapSorting {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 2, 4, 6, 8};
        int min = minSwap(arr);
        System.out.println("min: " + min);
    }

    public static int minSwap(int[] arrA) {
        int[] arrB = new int[arrA.length];
        int[] visited = new int[arrA.length];

        for (int i = 0; i < visited.length; i++)
            visited[i] = 0;

        for (int i = 0 ; i < arrA.length; i++)
               arrB[i] = arrA[i];
        Arrays.sort(arrB);

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < arrB.length; i++)
            map.put(arrB[i],i);

        int index1;
        int start;
        int move;
        int count = 0;
        for (int i = 0; i < arrB.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                move = arrA[i];
                start = arrB[i];

                while (start != move) {
                    index1 = map.get(move);
                    visited[index1] = 1;
                    count++;
                    move = arrA[index1];
                }
            }


        }

        return count;

    }


}
