package arrays;

import java.util.Arrays;

/**
 * Created by dmalladi on 10/20/2018.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
       // int[] arr = {1,1,2,3,3,4,5,6,6};
        int[] arr = {3,2,4,2,3,7,5,6,5,7};
        int[] newArr = removeDuplicatesInUnsortedArray(arr);
        print(newArr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static int[] removeDuplicatesInSortedArray(int[] arr) {
        int j = 0;
        int i = 1;
        while(i < arr.length) {
            if (arr[i] == arr[j]) {
                i++;
            }
            else {
                j++;
                arr[j] = arr[i];
                i++;
            }
        }
        int[] newArr = new int[j+1];
        for (int k = 0; k <= j; k++)
            newArr[k] = arr[k];
        return newArr;
    }

    public static int[] removeDuplicatesInUnsortedArray(int[] arr) {
        int len = arr.length;
        if (len == 1) return arr;

        int tail = 1;
        for (int i = 1; i < len; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (arr[j] == arr[i])
                    break;
            }
            if (j == tail) {
                arr[tail] = arr[i];
                tail++;
            }
        }
        int[] newArr = new int[tail];
        for (int i = 0; i < tail;i++)
            newArr[i] = arr[i];

        return newArr;
    }
}
