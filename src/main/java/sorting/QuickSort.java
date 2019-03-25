package sorting;

/**
 * Created by dmalladi on 10/29/2018.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,6,4,9,10,2,1,7,5,8};
        quickSort(arr,0,arr.length-1);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr,int start,int end) {
        if (start < end) {
            int pivotIndex = getPivotIndex(arr,start,end);
            quickSort(arr,start,pivotIndex-1);
            quickSort(arr,pivotIndex+1,end);

        }
    }

    public static int getPivotIndex(int[] arr,int start,int end) {
        int key = arr[end];
        int j = start-1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= key) {
                j = j+1;
                swap(arr,i,j);
            }
        }
        swap(arr,j+1,end);
        return j+1;
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
