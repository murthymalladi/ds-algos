package strings;

/**
 * Created by dmalladi on 11/20/2018.
 */
public class CheckRecord {
    public static void main(String[] args) {
        String str = "ALLAPPL";
        if (checkRecord(str)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    public static boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;
        int prevIndex = -2;
        char[] chars = s.toCharArray();
        int i = 0;
        while(i < chars.length) {
            if (chars[i] == 'A') {
                absentCount++;
            }
            else if (chars[i] == 'L') {
                while(i < chars.length && chars[i] == 'L') {
                    lateCount++;
                    i++;
                }
                if (lateCount > 2)
                    return false;
                lateCount = 0;
                if (i < chars.length && chars[i] == 'A')
                    absentCount++;
            }
            i++;
        }

        if (absentCount > 1 || lateCount > 2)
            return false;
        return true;
    }
}
