package patterns.slidingwindow;

/**
 * Created by dmalladi on 9/10/2019.
 */
public class SmallestSubArrayWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 1, 6};
        int S = 8;

        int minLength = findMinSubArray(S,arr);
        System.out.println(minLength);

    }

    public static int findMinSubArray(int S, int[] arr) {

        if (arr.length == 0 )
            return -1;

        int wordStart = 0;
        int wordSum = 0;
        int minSize = Integer.MAX_VALUE;

        for (int wordEnd = 0; wordEnd < arr.length; wordEnd++) {
            wordSum += arr[wordEnd];
            while(wordSum >= S) {
                minSize = Math.min(minSize,wordEnd-wordStart+1);
                wordSum -= arr[wordStart];
                wordStart++;
            }
        }
        if (minSize == Integer.MAX_VALUE)
            return -1;
        return minSize;
    }
}
