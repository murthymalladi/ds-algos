package arrays;

/**
 * @author dmalladi
 */
public class RotateRight {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int d = 3;
        rotRight(arr,d);
        printArray(arr);

    }

    public static void rotRight(int[] arr,int d) {
        int leftPos;
        int rightPos;
        for (int i = 0; i < d; i++) {
            leftPos = i;
            rightPos = arr.length - d + i;
            swap(arr,leftPos,rightPos);
        }
        rightPos = arr.length - d;
        for (int i = d;i < arr.length - d; i++) {
            swap(arr,i,rightPos);
            rightPos++;
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
