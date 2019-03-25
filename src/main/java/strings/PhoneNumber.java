package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 11/10/2018.
 */
public class PhoneNumber {

    public static void main(String[] args) {
        String input = "23";
        letterCombinations(input);
    }

    public static List<String> letterCombinations(String digits) {
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();

        letterCombinationUtil(letters,digits,0,"",result);

        for (String out: result) {
            System.out.print(out+ " ");
        }

        return result;
    }

    public static void letterCombinationUtil(String[] letters,String digits,int digitIndex,String output,List<String> result) {
        if (digitIndex == digits.length()) {
            result.add(output);
            return;
        }
        int digit = digits.charAt(digitIndex) - '0';
        for (int i = 0; i < letters[digit].length(); i++) {
            output = output + String.valueOf(letters[digit].charAt(i));
            letterCombinationUtil(letters,digits,digitIndex+1,output,result);
            output = output.substring(0,output.length()-1);
        }
    }
}
