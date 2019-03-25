package sorting;

/**
 * Created by dmalladi on 10/29/2018.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3,6,4,9,10,2,1,7,5,8};
        mergeSort(arr,0,arr.length-1);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr,int start,int end) {
        if (start < end) {
            int mid = start + (end - start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid+1,end);
        }

    }

    public static void merge(int[] arr,int start,int mid,int end) {
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid;
        int k = 0;

        while(i < mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i < mid) {
            temp[k] = arr[i];
            i++;k++;
        }
        while(j <= end) {
            temp[k] = arr[j];
            j++;k++;
        }

        //copy temp values into arr
        for (i = 0; i < temp.length; i++) {
            arr[start] = temp[i];
            start++;
        }
    }
}
