package arrays;

/**
 * Created by dmalladi on 10/22/2018.
 */
public class SearchInsertionPosition {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int target = 5;
        int index = searchInsertPosition2(arr,target);
        System.out.println(index);
    }

    public static int searchInsertPosition(int[] nums,int target) {
        if (nums == null)
            return -1;
        int start = 0;
        int end = nums.length;

        while(start < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target)
                return mid;
            else if (mid > 0 &&  (nums[mid-1] < target) && (nums[mid] > target) )
                return mid;
            else if (mid == 0 && nums[mid] > target)
                return mid;
            else if(mid == 0 && nums[mid] < target)
                return mid+1;
            else if (mid == nums.length-1 && nums[mid] < target)
                return mid+1;

            else if (nums[mid] < target) {
                 start = mid+1;
            }
            else if (nums[mid] > target) {
                end = mid -1;
            }
        }
        return -1;
    }

    public static int searchInsertPosition2(int[] nums,int target) {
        if (nums == null) return -1;
        int start = 0;
        int end = nums.length;
        int mid;

        while(start < end) {
            mid = start + (end - start)/2;
            if (nums[mid] > target) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return end;
    }
}
