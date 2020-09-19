package strings;

/**
 * Created by dmalladi on 1/5/2020.
 */
public class BackSpaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        if (S.length() == 0 && T.length() == 0)
            return true;
        return false;
    }

    public static String removeBackSpace(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "#a#c";
        String newString = removeBackSpace(str);
        System.out.println(newString);
    }
}
