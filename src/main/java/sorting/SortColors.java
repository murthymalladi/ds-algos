package sorting;

/**
 * Created by dmalladi on 11/9/2018.
 */
public class SortColors {

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void sortColors(int[] arr) {
        int s = 0;
        int e = arr.length-1;

        for (int i = 0; i < arr.length; i++) {
            if (i > e) break;
            if (arr[i] == 2) {
                while(i != e && arr[e] == 2)
                    e--;
                swap(arr,i,e);
                e--;
            }
        }

        for (int j = arr.length-1; j >= 0; j--) {
            if (s > j) break;
            if (arr[j] == 0) {
                while(s != j && arr[s] == 0)
                    s++;
                swap(arr,s,j);
                s++;
            }

        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
