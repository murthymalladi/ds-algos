package arrays;

/**
 * Created by dmalladi on 11/7/2018.
 */
public class CanJump {

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        if (canJumpRecursive(arr,0)) {
            System.out.println("can jump");
        }
        else {
            System.out.println("can not jump");
        }
        System.out.println("dp solution");
        if (canJumpDP(arr)) {
            System.out.println("can jump");
        }
        else {
            System.out.println("can not jump");
        }
    }

    public static boolean canJumpRecursive(int[] arr,int position) {
        if (position == arr.length-1)
            return true;

        int possibleLength = Math.min(arr.length-1,arr[position]+position);
        for (int nextPosition = position+1; nextPosition <= possibleLength; nextPosition++) {
            if (canJumpRecursive(arr,nextPosition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canJumpDP(int[] arr) {
        int len = arr.length;
        boolean[] dp = new boolean[len];

        dp[len-1] = true;
        for (int i = len-2; i>=0; i--) {
            int maxReach = Math.min(len-1,arr[i]+i);
            for (int k = i+1; k <= maxReach; k++) {
                if (dp[k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
