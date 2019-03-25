package Queue;

/**
 * Created by dmalladi on 12/10/2018.
 */
class MyCircularQueue {
    int[] arr;
    int k;
    int head;
    int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {

        arr = new int[k];
        head = 0;
        tail = 0;
        this.k = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        if (tail == k)
            tail = 0;
        arr[tail] = value;
        tail++;

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (head == tail)
            return false;
        if (head == k-1)
            head = 0;
        else
            head = head + 1;
        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if (!isEmpty())
            return arr[head];
        else
            return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (!isEmpty()) {
            if (tail == 0)
                return arr[k-1];
            else return arr[tail-1];
        }

        else return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if ((head == 0 && tail == k) || tail+1 == head)
            return true;
        else return false;
    }

    public static void main(String[] args) {

         //Your MyCircularQueue object will be instantiated and called as such:
          MyCircularQueue obj = new MyCircularQueue(3);
          boolean param_1 = obj.enQueue(1);
          boolean param_2 = obj.enQueue(2);
          boolean param_3 = obj.enQueue(3);
          boolean param_4 = obj.enQueue(4);
          int param_5 = obj.Rear();
          boolean param_6 = obj.isFull();
          boolean param_7 = obj.deQueue();
          boolean param_8 = obj.enQueue(3);

          int param_9 = obj.Rear();


    }
}

