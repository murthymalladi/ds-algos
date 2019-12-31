package patterns.cyclicsort;

/**
 * Created by dmalladi on 9/21/2019.
 */
public class FindTheDuplicateNumber {
    public static int findNumber(int[] nums) {
        // TODO: Write your code here
        int i = 0;

        while(i < nums.length) {
            int j = nums[i]-1;
            if (i != j) {
                if (nums[i] != nums[j])
                    swap(nums,i,j);
                else
                    return nums[i];
            }
            else {
                i++;
            }
        }
        return -1;
    }

    public static void swap(int[] nums,int i,int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        System.out.println(FindTheDuplicateNumber.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindTheDuplicateNumber.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindTheDuplicateNumber.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
