package strings;

/**
 * Created by dmalladi on 11/11/2018.
 */
public class EditDistance {

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        int dist = distance(str1,str1.length(),str2,str2.length());
        System.out.println(dist);
    }

    public static int distance(String str1,int m,String str2,int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (str1.charAt(m-1) == str2.charAt(n-1)) {
            return distance(str1,m-1,str2,n-1);
        }
        return 1 + min(distance(str1,m,str2,n-1),
                distance(str1,m-1,str2,n),
                distance(str1,m-1,str2,n-1));
    }

    public static int min(int a,int b,int c) {
        if (a < b) {
            if (a<c) {
                return a;
            }
            else {
                return c;
            }
        }
        else {
            if (b < c) {
                return b;
            }
            else {
                return c;
            }
        }
    }
}
