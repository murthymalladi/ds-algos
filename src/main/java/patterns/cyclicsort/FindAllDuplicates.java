package patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 9/22/2019.
 */
public class FindAllDuplicates {
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        // TODO: Write your code here
        int i = 0;
        while(i < nums.length) {
            if (nums[i] != nums[nums[i]] - 1) {
                swap(nums,i,nums[i]-1);
            }
            else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != i+1)
                duplicateNumbers.add(nums[j]);
        }
        return duplicateNumbers;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicates.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicates.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
