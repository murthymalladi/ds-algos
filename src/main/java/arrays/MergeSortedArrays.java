package arrays;

/**Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note:
   You may assume that A has enough space to hold additional elements from B.
  The number of elements initialized in A and B are m and n respectively
 * Created by dmalladi on 10/21/2018.
 */
public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] A = {2,5,7,0,0,0,0};
        int[] B = {1,4,6,8};
        merge(A,3,B,B.length);
        print(A);
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i]+" ");
    }

    public static void merge(int[] A,int m,int[] B,int n) {
        while(m > 0 && n > 0) {
            if (A[m-1] > B[n-1]) {
                A[m-1+n] = A[m-1];
                m--;
            }
            else {
                A[m-1+n] = B[n-1];
                n--;
            }
        }
        while (n > 0) {
            A[m-1+n] = B[n-1];
            n--;
        }
    }
}
