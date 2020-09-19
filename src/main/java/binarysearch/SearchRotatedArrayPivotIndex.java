package binarysearch;

/**
 * Created by dmalladi on 1/26/2020.
 */
public class SearchRotatedArrayPivotIndex {

    public static int search(int[] arr, int key) {
        int pivotIndex = findPivot(arr);

        int val = binarySearch(arr,key,0,pivotIndex-1);
        if (val != -1)
            return val;
        val = binarySearch(arr,key,pivotIndex,arr.length-1);
        if (val != -1)
            return val;
        return -1;
    }

    public static int binarySearch(int[] arr,int key,int start,int end) {

//        int start = 0;
//        int end = arr.length-1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            //ascending
            if (arr[start] < arr[end]) {
                if (arr[mid] == key) {
                    return mid;
                }
                else if (arr[mid] > key) {
                    end = mid-1;
                }
                else {
                    start = mid + 1;
                }
            }
            else { //descending order
                if (arr[mid] == key) {
                    return mid;
                }
                else if (arr[mid] > key) {
                    start = mid + 1;
                }
                else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while(start < end) {

            int mid = start + (end - start)/2;
            if (arr[mid] > arr[end]) {
                start = mid+1;
            }
            else if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) {
                return mid;
            }
            else {
                end = mid-1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
//        System.out.println(SearchRotatedArrayPivotIndex.findPivot(new int[] {  10,1,2,3,4,5,6,7,8,9 }));
//        System.out.println(SearchRotatedArrayPivotIndex.findPivot(new int[] { 4, 5, 7, 9, 10, -1, 2 }));

        System.out.println(SearchRotatedArrayPivotIndex.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchRotatedArrayPivotIndex.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));

    }
}
