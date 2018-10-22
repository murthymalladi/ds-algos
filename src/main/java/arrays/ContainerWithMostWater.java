package arrays;

/**
 * Created by dmalladi on 10/20/2018.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int val = mostWaterContainer2(arr);
        System.out.println(val);
    }

    /**
     *  O(n*n) approach
     * @param container
     * @return
     */
    public static int mostWaterContainer(int[] container) {
        int max = Integer.MIN_VALUE;
        int currMax = container[0];
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                currMax = Math.min(container[i],container[j]) * (j-i);
                if (currMax > max)
                    max = currMax;
            }
        }
        return max;
    }

    /**
     * O(n) approach
     * @return
     */
    public static int mostWaterContainer2(int[] container) {
        int start = 0;
        int end = container.length-1;
        int max = 0;
        int currMax;
        while(start < end) {
            currMax = Math.min(container[start],container[end])*(end-start);
            max = Math.max(max,currMax);
            if (container[start] < container[end])
                start++;
            else
                end--;
        }
        return max;
    }
}
