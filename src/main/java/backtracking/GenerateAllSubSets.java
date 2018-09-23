package backtracking;

/**
 * Created by dmalladi on 9/8/2018.
 */
public class GenerateAllSubSets {
    public static void main(String[] args) {
        int[] set = {1,2,3,4};
        generateSubSets(set);
    }

    public static void generateSubSets(int[] set) {
        int n = set.length;
        // 1<<n is the 2^n
        for (int i = 0; i < (1 << n); i++) {

            System.out.print("{");
            for (int j = 0; j < n; j++) {
                if ( (i & (1<<j)) > 0) {
                    System.out.print(set[j]+",");
                }
            }
            System.out.println("}");
        }
    }
}
