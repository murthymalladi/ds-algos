package binarysearch;

/**
 * Created by dmalladi on 10/16/2018.
 */
public class FirstOccurence {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,4,4,5,5,5,5,5,6,7,9,10};
        int[] arr2 = {4,4,4,5,5,5,5,5,6,7,9,10,11,11,12};
        int val1 = firstOccurence(arr1,5);
        int val2 = firstOccurence(arr2,4);

        System.out.println("val1: " + val1);
        System.out.println("val2: " + val2);
    }

    public static int firstOccurence(int[] arr,int item) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start <= end) {
            mid = start + (end - start)/2;
            if (mid > 0 && arr[mid - 1] < item && arr[mid] == item) {
                return mid;
            }
            else if(mid == 0 && arr[mid] == item) {
                return mid;
            }
            else if(arr[mid] >= item) {
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
