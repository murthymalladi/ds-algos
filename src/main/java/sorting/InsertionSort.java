package sorting;

/**
 * Created by dmalladi on 10/29/2018.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3,6,4,9,10,2,1,7,5,8};
        insertionSort(arr);
        print(arr);
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void insertionSort(int[] arr) {
        int i = 0;
        int key;
        for (int j = 1; j < arr.length; j++) {
            i = j-1;
            key = arr[j];
            while(i >= 0 && key < arr[i]) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }

}
