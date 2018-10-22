package strings;

/**
 * Created by dmalladi on 10/20/2018.
 */
public class CommonPrefix {

    public static void main(String[] args) {
        String str1 = "flow";
        String str2 = "flow";
        String prefix = prefix(str1,str2);
        System.out.println(prefix);
    }

    public static String prefix(String s1,String s2) {
        int index = s2.indexOf(s1);
        return s1.substring(0,index);
    }
}
