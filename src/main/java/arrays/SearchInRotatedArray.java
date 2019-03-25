package arrays;

/**
 * Created by dmalladi on 11/3/2018.
 */
public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int index = search(arr,0);
      //  int pivot = findPivot(arr,0,arr.length-1);
        System.out.println(index);
    }

    public static int findPivot(int[] nums,int start,int end) {
        if (start > end)
            return -1;

        if(start < end) {
            int mid = start + (end-start)/2;
            if (mid < end && nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] < nums[start]) {
                return findPivot(nums,start,mid);
            }
            else {
                return findPivot(nums,mid+1,end);
            }
        }
        return -1;
    }

    public static int search(int[] nums,int target) {
        int pivotIndex = findPivot(nums,0,nums.length-1);
        if (pivotIndex == -1) {
            return binarySearch(nums,0,nums.length-1,target);
        }
        if (nums[0] > target) {
            return binarySearch(nums,pivotIndex+1,nums.length-1,target);
        }
        else {
            return binarySearch(nums,0,pivotIndex,target);
        }
    }



    public static int binarySearch(int[] nums,int start,int end,int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }


}
