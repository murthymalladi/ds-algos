package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmalladi on 12/27/2019.
 */
public class EmailForward {

    public static int numUniqueEmails(String[] emails) {
        if (emails.length == 0)
            return 0;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];
            String localName = "";
            String[] names = email.split("@");
            localName = names[0];
            if (names[0].contains("+")) {
                localName = names[0].split("\\+")[0];
                System.out.println(localName);

            }
//            if (localName.contains("."))
//                localName = localName.replaceAll(".","");
            String localName2 = localName.replaceAll("\\.","");
            System.out.println(localName2);
            email = localName2+"@"+names[1];
            if (!set.contains(email))
                set.add(email);


        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        int count = numUniqueEmails(emails);
        System.out.println(count);
    }
}
