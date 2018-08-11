package arrays;

/**
 * Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts.
 1) All elements smaller than lowVal come first.
 2) All elements in range lowVal to highVVal come next.
 3) All elements greater than highVVal appear in the end.
 The individual elements of three sets can appear in any order.
 */
public class ThreeWayPartition {

    public static void main(String[] args) {
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87,98, 3, 1, 32};
        threeWayPartition(arr,10,20);
        printArray(arr);

    }

    private static void threeWayPartition(int[] arr,int low,int high) {

        int start = 0;
        int end = arr.length - 1;

        for (int i = 0; i <= end;) {
            if (arr[i] < low) {
                swap(arr,i,start);
                start = start + 1;
                i = i+1;
            }
            else if (arr[i] > high) {
                swap(arr,i,end);
                end = end - 1;

            }
            else {
                i = i+1;
            }
        }

    }

    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap(int[] arr,int i,int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }


}
