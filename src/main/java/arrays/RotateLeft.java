package arrays;

/**
 * @author dmalladi
 */
public class RotateLeft {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
        int d = 4;
        rotLeft(arr,5);
        printArray(arr);

    }

    public static void rotLeft(int[] arr,int d) {

        for (int i = 0; i < d; i++)
            rotByOne(arr);
    }
    public static void rotByOne(int[] arr) {

        int a = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = a;
    }
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
