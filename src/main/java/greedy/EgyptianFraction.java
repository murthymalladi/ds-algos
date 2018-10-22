package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 9/26/2018.
 */
public class EgyptianFraction {
    public static void main(String[] args) {

        egyptian(6,14);
    }

    public static void egyptian(int nr1,int dr1) {
        List<int[]> list = new ArrayList<int[]>();
        int val = (int) Math.ceil((double) dr1/nr1);
        list.add(new int[]{1,val});
        int[] fractions = subtractFractions(nr1,dr1,1,val);

        while(fractions[0] != 1) {
            val = (int) Math.ceil((double) fractions[1]/fractions[0]);
            list.add(new int[]{1,val});
            fractions = subtractFractions(fractions[0],fractions[1],1,val);
            if (fractions[1]%fractions[0] == 0) {
                fractions[1] = fractions[1]/fractions[0];
                fractions[0] = 1;
                list.add(fractions);
            }

        }

        for(int[] arr: list) {
            System.out.println(arr[0]+" "+arr[1]);
        }
    }


    public static int[] subtractFractions(int nr1,int dr1,int nr2,int dr2) {
        int nr3 = (nr1*dr2 - dr1*nr2);
        int dr3 = (dr1 * dr2);
        int[] fractions = new int[2];
        fractions[0] = nr3;
        fractions[1] = dr3;
        return fractions;
    }
}
