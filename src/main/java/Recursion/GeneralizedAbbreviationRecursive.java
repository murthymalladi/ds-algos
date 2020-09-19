package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 1/25/2020.
 */
public class GeneralizedAbbreviationRecursive {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> res = new ArrayList<>();
        helper(word,"",res,0,0);
        return res;
    }

    public static void helper(String word,String result,List<String> res,int start,int count) {
        if (start == word.length()) {
            if (count != 0)
                result = result + String.valueOf(count);
            res.add(result);
        }
        else {
            helper(word,result,res,start+1,count+1);

            if (count != 0)
                result = result + String.valueOf(count);
            helper(word,result+word.charAt(start),res,start+1,0);
        }
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviationRecursive.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }
}
