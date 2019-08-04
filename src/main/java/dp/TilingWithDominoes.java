package dp;

/**
 * Created by dmalladi on 7/20/2019.
 */
public class TilingWithDominoes {

    public static void main(String[] args) {

    }

    public static int numWaysRecur(int row,int col) {
        if (col == 1)
            return 0;
        if (col == 2)
            return 3;
        return 3 + numWaysRecur(row,col-2);
    }
}
