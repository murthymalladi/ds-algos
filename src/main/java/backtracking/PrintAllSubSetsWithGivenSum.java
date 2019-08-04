package backtracking;

/**
 * Created by dmalladi on 7/17/2019.
 */
public class PrintAllSubSetsWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int sum = 3;
        combinations(arr,sum);
    }

    public static void combinations(int[] A,int sum) {
        int[] sol = new int[A.length];
        combinationsUtil(sol,A,sum,0,0);
    }

    public static void combinationsUtil(int[] A,int[] B,int sum,int currSum,int index) {
        if (sum == currSum) {
            printArray(A,B);
            return;
        }
        if (index == B.length-1) {
            return;
        }
        A[index] = 0; //doesn't include in the result
        combinationsUtil(A,B,sum,currSum,index+1);
        A[index] = 1; //include the current element
        combinationsUtil(A,B,sum,currSum + B[index],index+1);
    }

    public static void printArray(int[] A,int[] B) {
        for (int i = 0; i < B.length; i++) {
            if (A[i] == 1) {
                System.out.print(B[i]+" ");
            }
        }
        System.out.println();
    }

}
