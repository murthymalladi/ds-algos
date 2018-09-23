package graphs;

/**
 * Created by dmalladi on 8/15/2018.
 */
public class BinaryMinHeap {
    private int capacity;
    private int heapSize;
    VertexWithKey[] heapArray;

    public BinaryMinHeap() {
        capacity = 20;
        heapSize = 0;
        heapArray = new VertexWithKey[capacity];
    }

    public BinaryMinHeap(int heapCapacity) {
        capacity = heapCapacity;
        heapSize = 0;
        heapArray = new VertexWithKey[heapCapacity];
    }

    public void insertKey(VertexWithKey keyNode) {
        if (heapSize < capacity) {
            heapArray[heapSize] = keyNode;
            heapSize = heapSize + 1;
        }
        else {
            doubleHeapCapacity();
            heapArray[heapSize] = keyNode;
            heapSize = heapSize + 1;
        }
        int i = heapSize - 1;
        while (i > 0 && heapArray[parent(i)].getKey() > heapArray[i].getKey()) {
            swap(heapArray,parent(i),i);
            i = parent(i);
        }
    }

    public VertexWithKey extractMin() {
        VertexWithKey min = heapArray[0];
        swap(heapArray,0,heapSize-1);
        heapSize = heapSize - 1;
        minHeapify(heapArray,0,heapSize);
        return min;
    }

    private void minHeapify(VertexWithKey[] A,int i,int n) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int smallest = i;

        if (left < n && A[left].getKey() < A[i].getKey()) {
            smallest = left;
        }
        if (right < n && A[right].getKey() < A[smallest].getKey()) {
            smallest = right;
        }
        if (smallest != i) {
            swap(A,i,smallest);
            minHeapify(A,smallest,n);
        }
    }

    public void buildMinHeap() {
        for (int i = heapSize/2; i >=0; i--) {
            minHeapify(heapArray,i,heapSize);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void decreaseKey(int id,int parent,int key) {
        int index = findKey(id);
        heapArray[index].setKey(key);
        heapArray[index].setParent(parent);
        while(index > 0 && heapArray[parent(index)].getKey() > heapArray[index].getKey()) {
            swap(heapArray,parent(index),index);
            index = parent(index);
        }
    }

    private int findKey(int id) {
        for (int i = 0; i < heapSize; i++) {
            if (heapArray[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int getWeight(int id) {
        int weight = Integer.MAX_VALUE;
        for (int i = 0; i < heapSize; i++) {
            if (heapArray[i].getId() == id) {
                weight = heapArray[i].getKey();
            }
        }
        return weight;
    }

    private void doubleHeapCapacity() {
        int doubleCapacity = 2*capacity;
        VertexWithKey[] temp = new VertexWithKey[capacity];

        for (int i = 0; i < heapSize; i++) {
            temp[i] = heapArray[i];
        }
        heapArray = new VertexWithKey[doubleCapacity];
        for (int i = 0; i < capacity; i++)
            heapArray[i] = temp[i];

        this.capacity = doubleCapacity;
    }

    public boolean containsId(int id) {
        for (int i = 0; i < heapSize; i++) {
            if (heapArray[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private void swap(VertexWithKey[] A,int i,int j) {
        VertexWithKey temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}
