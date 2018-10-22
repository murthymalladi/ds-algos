package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**Given “n”, generate all valid parenthesis strings of length “2n”.
 * @author dmalladi
 */
public class PrintAllParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("Give n: ");
        int n = scanner.nextInt();

        printParentheses(n,n,"");
        int[] count = new int[1];
        count[0] = 0;
        countAllPossibleParentheses(n,n,"",count);
        System.out.println("count : "+ count[0]);

        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(sb.length() - 1);

    }

    /**
     * prints all valid parentheses of length 2n given n.
     * @param open
     * @param close
     * @param str
     */
    public static void printParentheses(int open,int close,String str) {
        if (open == 0 && close == 0) {
            System.out.println(str);
            return;
        }

        if (open > close)
            return;

        if (open > 0)
          printParentheses(open-1,close,str+"(");

        if (close > 0)
          printParentheses(open,close-1,str+")");
   }

    /**
     * prints the count of all possible valid parentheses of 2n length given n.
     * @param open
     * @param close
     * @param str
     * @param count
     */


   public static void countAllPossibleParentheses(int open,int close,String str,int[] count) {

        if (open == 0 && close == 0) {
            System.out.println(str);
            count[0]++;
        }
        if (open > close)
            return;

        if (open > 0)
            countAllPossibleParentheses(open-1,close,str+"(",count);
        if (close > 0)
            countAllPossibleParentheses(open,close-1,str+")", count);
   }
}
