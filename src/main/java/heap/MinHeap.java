package heap;

/**
 * Created by dmalladi on 8/15/2018.
 */
public class MinHeap {

    private int capacity;
    private int heapSize;
    int[] heapArray;

    public MinHeap() {
        capacity = 5;
        heapSize = 0;
        heapArray = new int[capacity];
    }
    public MinHeap(int heapCapacity) {
        capacity = heapCapacity;
        heapSize = 0;
        heapArray = new int[heapCapacity];
    }

    public MinHeap(int[] arr) {
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
        while (i > 0 && heapArray[parent(i)] > heapArray[i]) {
            swap(heapArray,parent(i),i);
            i = parent(i);
        }
    }

    private void decreaseKey(int index,int key) {
        heapArray[index] = key;
        while(index > 0 && heapArray[parent(index)] > heapArray[index]) {
            swap(heapArray,parent(index),index);
            index = parent(index);
        }
    }

    private int extractMin() {
        int min = heapArray[0];
        swap(heapArray,0,heapSize-1);
        heapSize = heapSize - 1;
        minHeapify(heapArray,0,heapSize);
        return min;
    }

    private boolean isEmpty() {
        return heapSize == 0;
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private void buildMinHeap() {
        for (int i = heapSize/2; i >=0; i--) {
            minHeapify(heapArray,i,heapSize);
        }
    }

    private void minHeapSort() {
        buildMinHeap();
        for (int i = heapSize-1; i >= 0; i--) {
            swap(heapArray,0,i);
            minHeapify(heapArray,0,i);
        }
    }


    private void minHeapify(int[] A,int i,int n) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int smallest = i;

        if (left < n && A[left] < A[i]) {
            smallest = left;
        }
        if (right < n && A[right] < A[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(A,i,smallest);
            minHeapify(A,smallest,n);
        }
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

    private  void printHeapArray() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heapArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {16,14,10,8,7,9,3,2,4,1};

        MinHeap minHeap = new MinHeap(arr);
        minHeap.buildMinHeap();
       // minHeap.minHeapSort();
        minHeap.printHeapArray();
        minHeap.decreaseKey(3,0);
        System.out.println();
        minHeap.printHeapArray();

//        for (int i = 0; i < 5; i++) {
//            System.out.println(minHeap.extractMin());
//        }
//        minHeap.insertKey(11);
//        System.out.println("added new element ");
//        System.out.println(minHeap.extractMin());
//        System.out.println("\n\nremaining array: ");
//        minHeap.printHeapArray();

    }
}
