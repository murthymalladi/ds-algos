package arrays;

/**
 * Created by dmalladi on 10/3/2019.
 */
public class MergeArray {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[] arr3 = new int[n+m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                arr3[k] = arr1[i];
                i++;k++;
            }
            else {
                arr3[k] = arr2[j];
                j++;k++;
            }
        }

        while(i < n) {
            arr3[k] = arr1[i];
            i++;k++;
        }
        while(j < m) {
            arr3[k] = arr2[j];
            k++;j++;
        }
        return arr3;
    }
    public static void main(String args[]) {

        int[] arr1 = {1,12,14,17,23}; // creating a sorted array called arr1
        int[] arr2 = {11,19,27};  // creating a sorted array called arr2

        int[] resultantArray = mergeArrays(arr1, arr2); // calling mergeArrays

        System.out.print("Arrays after merging: ");
        for(int i = 0; i < arr1.length + arr2.length; i++) {
            System.out.print(resultantArray[i] + " ");
        }
    }
}
