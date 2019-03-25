package strings;

import java.util.Arrays;

/**
 * Created by dmalladi on 11/20/2018.
 */
public class NextNumber {

    public static void main(String[] args) {
        int n = 198765432;
        int res = nextGreaterElement(n);
        System.out.println(res);



    }

    public static int nextGreaterElement(int n) {
        String number = String.valueOf(n);
        char[] chars = number.toCharArray();
        int i = chars.length-1;
        char temp;
        char small = '9';
        int j;
        int smallIndex = -1;
        while(i > 0) {
            if (chars[i] > chars[i-1]) {
                  j = i;
                  small = chars[j];
                  smallIndex = j;
                  while(j < chars.length) {
                      if (chars[j] > chars[i-1]) {
                          if (chars[j] < small) {
                              small = chars[j];
                              smallIndex = j;
                          }
                      }
                      j++;
                  }

                temp = chars[i-1];
                chars[i-1] = chars[smallIndex];
                chars[smallIndex] = temp;
                //reverse(chars,i,chars.length-1);
                Arrays.sort(chars,i,chars.length);
                break;
            }
            i--;
        }
        if ( i == 0)
            return -1;
        if (isOverFlow(chars))
            return -1;
        return Integer.valueOf(String.valueOf(chars));

    }

    public static boolean isOverFlow(char[] chars) {
        char[] maxNum = {'2','1','4','7','4','8','3','6','4','7'};
        if (chars.length < maxNum.length)
            return false;
        else if (chars.length > maxNum.length)
            return true;
        else {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > maxNum[i])
                    return true;
            }
        }
        return false;
    }

    public static void reverse(char[] chars,int i,int j) {
        char temp;

        while(i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;j--;
        }
    }
}
