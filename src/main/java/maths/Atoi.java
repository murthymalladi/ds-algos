package maths;

/**
 * Created by dmalladi on 10/19/2018.
 */
public class Atoi {

    public static void main(String[] args) {
        String str = "-91283472332";
        int val = atoi(str);
        System.out.println(val);
    }

    public static int atoi(String str) {
        int len = str.length();
        int i = 0;
        int flag = 1;
        int num = 0;
        while(i < len && str.charAt(i) == ' ')
            i++;
        if (i == len) return 0;

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            flag = str.charAt(i) == '+'? 1:-1;
            i++;
        }
        else if (!((str.charAt(i) - 48)>= 0 && (str.charAt(i) - 48) < 10))
            return 0;

        while( (i < len) && ((str.charAt(i) - 48) >=0 && (str.charAt(i) - 48) < 10)  ) {

            int val = num*10 + str.charAt(i) - 48;
//            if ( (val - (str.charAt(i) - 48))/10 != num ) {
//                if (flag == 1)
//                    return Integer.MAX_VALUE;
//                else
//                    return Integer.MIN_VALUE;
//            }
            if (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && (str.charAt(i) - 48) > 7)) {
                if (flag == 1) {
                     return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
//            if (num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE/10 && (str.charAt(i) - 48) < -8)) {
//                if (flag == -1) {
//                    return Integer.MAX_VALUE;
//                }
//                else {
//                    return Integer.MIN_VALUE;
//                }
//            }

            num = val;
            i++;

        }

        int digit = str.charAt(i-1) - 48;
        if (digit >= 0 && digit < 10)
            return flag*num;
        else return 0;
     }


}
