package patterns.cyclicsort;

/**
 * Created by dmalladi on 9/21/2019.
 */
public class CyclicSort {

    public static void sort(int[] nums) {
        // TODO: Write your code here
        int i = 0;
        while(i < nums.length) {
            if (nums[i] == i+1)
                i++;
            else {
                swap(nums,i,nums[i]-1);
            }
        }
    }

    public static void swap(int[] nums,int i,int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
