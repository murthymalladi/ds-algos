package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmalladi on 11/11/2018.
 */
public class ValidIPAddress {

    public static void main(String[] args) {
        String ip = "00001";
        List<String> output = new ArrayList<String>();
        validIPAddress(ip, 0, 0, output,"");
        System.out.println(output);
    }


    public static void validIPAddress(String ipAddress, int index, int dots, List<String> output,String result) {
        if (ipAddress.length() == 0)
            return;
        if (dots == 3) {
            if (ipAddress.substring(index).length() > 1 && ipAddress.charAt(index) == '0')
                return;
            if (ipAddress.substring(index).length() > 3)
                return;
            if (Integer.parseInt(ipAddress.substring(index)) <= 255) {
                result = result + ipAddress.substring(index);
                output.add(result);
            }

            return;
        }
        if (index == ipAddress.length() - 1)
            return;


        for (int i = index + 1; i < ipAddress.length() && i <= index + 3; i++) {
            if (ipAddress.substring(index, i).length() > 1 && ipAddress.charAt(index) == '0')
                    continue;
            if (Integer.parseInt(ipAddress.substring(index, i)) <= 255) {
                validIPAddress(ipAddress, i, dots + 1, output,result + ipAddress.substring(index, i) + ".");
            }
        }
    }

}
