package arrays;

/**
 * Created by dmalladi on 12/28/2019.
 */
public class JumpGame {

    public static boolean jump(int[] arr) {
        return jumpHelper(arr,0);
    }

    public static boolean jumpHelper(int[] arr,int index) {
        if (index >= arr.length-1)
            return true;
        int steps = arr[index];
        for (int i = 1; i <= steps; i++) {
            if (i+index < arr.length-1 && jumpHelper(arr,index+i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        if (jump(arr)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}
