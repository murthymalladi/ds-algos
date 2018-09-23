package heap;

/**
 * Created by dmalladi on 8/14/2018.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {16,14,10,8,7,9,3,2,4,1};
        heapSort(arr);
        printArray(arr);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] A) {
        int n = A.length;
        buildHeap(A);

        for (int i = n-1; i>= 0; i--) {
            swap(A,0,i);
            heapify(A,0,i);

        }
    }

    public static void buildHeap(int[] A) {
        int n = A.length;
        for (int i = n/2; i >= 0; i--) {
            heapify(A,i,n);
        }
    }

    public static void heapify(int[] A,int i,int n) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;
        if (left < n && A[left] > A[i]) {
            largest = left;
        }
        if (right < n && A[right] > A[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(A,i,largest);
            heapify(A,largest,n);
        }
   }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
