package patterns.binarysearch;

/**
 * Created by dmalladi on 10/2/2019.
 */
public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        // TODO: Write your code here
        int start = 0;
        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] > key) {
                end = mid - 1;
            }
            else if (arr[mid] < key) {
                start = start+1;
            }
            else {
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
