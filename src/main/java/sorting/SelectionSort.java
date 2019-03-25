package sorting;

/**
 * Created by dmalladi on 10/29/2018.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3,6,4,9,10,2,1,7,5,8};
        selectionSort(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = getMin(arr,i,arr.length-1);
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int getMin(int[] arr,int start,int end) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
