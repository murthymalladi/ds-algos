package backtracking;

/**
 * @author dmalladi
 */
public class GenerateBinaryString {

    public static void main(String[] args) {
        int[] arr = new int[3];
        binary(arr,arr.length);
    }

    public static void binary(int[] arr,int n) {

        if (n < 1) {
            printArray(arr);
        }
        else {

            arr[n - 1] = 0;
            binary(arr, n - 1);
            arr[n - 1] = 1;
            binary(arr, n - 1);
        }
    }

    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
