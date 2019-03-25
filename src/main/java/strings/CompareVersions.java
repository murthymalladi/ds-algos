package strings;

/**
 * Created by dmalladi on 11/12/2018.
 */
public class CompareVersions {

    public static void main(String[] args) {
        String s1 = "1.1.3";
        String s2 = "1.1";
        System.out.println(compareVersion(s1,s2));

    }

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int i = 0;
        int j = 0;

        while(i < s1.length && j < s2.length) {
            if (Integer.valueOf(s1[i]) > Integer.valueOf(s2[j]) )
                return 1;
            else if (Integer.valueOf(s1[i]) < Integer.valueOf(s2[j]))
                return -1;
            else {
                if (i == s1.length-1 && j == s2.length-1 )
                    return 0;
                i++;
                j++;
            }
        }
        if (i <  s1.length)
            return 1;
        else {
            return -1;
        }

    }
}
