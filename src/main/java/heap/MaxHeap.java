package heap;

 /**
 * Created by dmalladi on 8/15/2018.
 */
public class MaxHeap {

    private int capacity;
    private int heapSize;
    int[] heapArray;

    public MaxHeap() {
        capacity = 5;
        heapSize = 0;
        heapArray = new int[capacity];
    }

    public MaxHeap(int heapCapacity) {
        capacity = heapCapacity;
        heapSize = 0;
        heapArray = new int[heapCapacity];
    }

    public MaxHeap(int[] arr) {
        this.capacity = arr.length;
        this.heapSize = arr.length;
        heapArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            heapArray[i] = arr[i];
    }

    public void insertKey(int key) {
        if (heapSize < capacity) {
            heapArray[heapSize] = key;
            heapSize = heapSize + 1;
        }
        else {
            doubleHeapCapacity();
            heapArray[heapSize] = key;
            heapSize = heapSize + 1;
        }
        int i = heapSize - 1;
        while (i > 0 && heapArray[parent(i)] < heapArray[i]) {
            swap(heapArray,parent(i),i);
            i = parent(i);
        }
    }

    private int parent(int i) {
        return (i-1)/2;
    }
    private int extractMax() {
        int max = heapArray[0];
        swap(heapArray,0,heapSize-1);
        heapSize = heapSize - 1;
        maxHeapify(heapArray,0,heapSize);
        return max;
    }
    private void doubleHeapCapacity() {
        int doubleCapacity = 2*capacity;
        int[] temp = new int[capacity];

        for (int i = 0; i < heapSize; i++) {
            temp[i] = heapArray[i];
        }
        heapArray = new int[doubleCapacity];
        for (int i = 0; i < capacity; i++)
            heapArray[i] = temp[i];

        this.capacity = doubleCapacity;
    }

    private void buildMaxHeap() {
        for (int i = heapSize/2; i >=0; i--) {
            maxHeapify(heapArray,i,heapSize);
        }
    }

    private void maxHeapSort() {
        buildMaxHeap();
        for (int i = heapSize-1; i >= 0; i--) {
            swap(heapArray,0,i);
            maxHeapify(heapArray,0,i);
        }
    }

    private void maxHeapify(int[] A,int i,int n) {
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
            maxHeapify(A,largest,n);
        }
    }

    private void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {16,14,10,8,7,9,3,2,4,1};

        MaxHeap maxHeap = new MaxHeap(arr);
        maxHeap.buildMaxHeap();
       // maxHeap.maxHeapSort();
      //  maxHeap.printHeapArray();

        for (int i = 0; i < 5; i++) {
            System.out.println(maxHeap.extractMax());
        }
        maxHeap.insertKey(11);
        System.out.println("added new element ");
        System.out.println(maxHeap.extractMax());
        System.out.println("\n\nremaining array: ");
        maxHeap.printHeapArray();

    }

    private  void printHeapArray() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heapArray[i] + " ");
        }
    }

}
