package backtracking;

/**
 * Created by dmalladi on 7/17/2019.
 */
public class PrintAllSubSets {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        combinations(arr);
    }

    public static void combinations(int[] A) {
        int[] sol = new int[A.length];
        combinationsUtil(sol,A,0);
    }

    public static void printArray(int[] A,int[] B) {
        for (int i = 0; i < B.length; i++) {
            if (A[i] == 1) {
                System.out.print(B[i]+" ");
            }
        }
        System.out.println();
    }

    public static void combinationsUtil(int[] A,int[] B,int index) {
        if (index == B.length-1) {
            A[index] = 0; // don't consider last element
            printArray(A,B);
            A[index] = 1; // consider last element
            printArray(A,B);

        }
        else {
            A[index] = 0;
            combinationsUtil(A,B,index+1);
            A[index] = 1;
            combinationsUtil(A,B,index+1);
        }
    }
}
