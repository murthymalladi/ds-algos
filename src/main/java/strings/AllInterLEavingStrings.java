package strings;

/**
 * Created by dmalladi on 11/11/2018.
 */
public class AllInterLEavingStrings {

    public static void main(String[] args) {
        String str1 = "AB";
        String str2 = "CD";
        printInterLeaving(str1,str2,"");
    }

    public static void printInterLeaving(String str1,String str2,String interleaving) {

        if (str1.length() == 0 && str2.length() == 0) {
            System.out.println(interleaving);
            return;
        }

        if (str1.length() != 0) {
            printInterLeaving(str1.substring(1),str2,interleaving+str1.charAt(0));
        }
        if (str2.length() != 0) {
            printInterLeaving(str1,str2.substring(1),interleaving+str2.charAt(0));
        }

    }
}
