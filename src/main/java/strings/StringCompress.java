package strings;

/**
 * Created by dmalladi on 11/17/2018.
 */
public class StringCompress {

    public static void main(String[] args) {
        char[] chars = {'a','b','c','c','c','d'};
        int length = compress(chars);
        print(chars,length);

    }

    public static void print(char[] chars,int length) {
        for (int i = 0; i < length; i++)
            System.out.print(chars[i]+" ");
        System.out.println();
    }

    public static int compress(char[] chars) {
        if (chars.length == 0)
            return 0;
        if (chars.length == 1)
            return 1;
        int i = 0;
        int j = chars.length-1;
        int count = 1;
        int pointer = 0;
        char prev = chars[0];
        while(i < j) {
            while(i < j && chars[i] != chars[i+1]) {
                chars[pointer] = chars[i];
                pointer++;i++;
            }
            if (i == j) return pointer+1;

            while(i < j && chars[i] == chars[i+1]) {
                count++;i++;
            }
            if (count > 1) {
                pointer = pointer+1;
                chars[pointer] = Character.forDigit(count,10);
                pointer++;
                count=1;
            }
            i++;
        }


        return pointer;
    }
}
