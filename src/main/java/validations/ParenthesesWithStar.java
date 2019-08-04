package validations;

/**
 * Created by dmalladi on 4/5/2019.
 */
public class ParenthesesWithStar {

    public static void main(String[] args) {
        String s = "(*)";
        if (isValid(s)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }

    public static boolean isValid(String s) {
        return helper(s, 0, 0);
    }

    public static boolean helper(String s, int start, int count) {
        if (count < 0)
            return false;
        char c;
        for (int i = start; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count <= 0)
                    return false;
                count--;
            } else if (c == '*') {
                return helper(s, i+1, count + 1) || helper(s, i+1, count - 1) || helper(s, i+1, count);
            }
        }
        if (count == 0)
            return true;
        return false;
    }

}
