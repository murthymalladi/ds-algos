package validations;

/**
 * Created by dmalladi on 4/5/2019.
 */
public class ValidatePArentheses2 {

    public static void main(String[] args) {
        String parentheses = "()()()((()))";
        if (isValidParantheses(parentheses)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }

    public static boolean isValidParantheses(String s) {
        return helper(s,0,0);
    }

    public static boolean helper(String s,int start,int count) {


        for (int i = start;i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            else if (s.charAt(i) == ')') {
                if (count <= 0)
                    return false;
                count--;
            }
        }
        if (count == 0)
            return true;
        return false;
    }
}
