package strings;

/**
 * Created by dmalladi on 11/16/2018.
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String str = "hello";
        String output = reverseVowels(str);
        System.out.println(output);
    }
    public static String reverseVowels(String s) {
        if(s.length() == 0 || s == null)
            return s;
        int i = 0;
        int j = s.length()-1;
        char[] charArray = s.toCharArray();
        char ch;
        while(i < j) {
            while(i < j && !isVowel(charArray[i])) i++;
            while(i < j && !isVowel(charArray[j])) j--;

            ch = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = ch;
            i++;j--;
        }
        return new String(charArray);
    }

    public static boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch =='o' || ch =='u')
            return true;
        return false;
    }
}
