package strings;

/**
 * Created by dmalladi on 11/18/2018.
 */
public class CheckIPAddress {

    public static void main(String[] args) {
        String ipAddress = "001:0db8:85a3:0::0:8A2E:0370:7334";
        String value = validIPAddress(ipAddress);
        System.out.println(value);
    }
    public static String validIPAddress(String IP) {
        String[] segments;

        if (IP.contains(".")){
            segments = IP.split("\\.");
            if (segments.length != 4)
                return "Neither";
            int count = 0;
            for (int i = 0; i < segments.length; i++) {
                if (segments[i].length() == 0 || segments[i].charAt(0) == '0')
                    return "Neither";
                if (isValidNumber(segments[i]))
                    count++;
            }
            if (count == 4)
                return "IPv4";
        }
        if (IP.contains(":")) {
            if (IP.charAt(0) == ':' || IP.charAt(IP.length()-1) == ':')
                  return "Neither";
            segments = IP.split(":");
            if (segments.length != 8)
                return "Neither";

            int count = 0;
            for (int i = 0; i < segments.length; i++) {
                if (segments[i].length() == 0 || segments[i].length() > 4)
                    return "Neither";
                if (!isHexa(segments[i]))
                    return "Neither";
                count++;

            }
            if (count == 4)
                return "IPv6";
        }

        return "Neither";
    }

    public static boolean isValidNumber(String value) {
        char c;
        for (int i = 0 ;i < value.length(); i++) {
            c = value.charAt(i);
            if (!(c >= '0' && c<= '9') )
                return false;
        }

        if (Integer.valueOf(value) >= 0 && Integer.valueOf(value) <= 255)
            return true;
        return false;
    }

    public static boolean isHexa(String value) {

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') ) )
                return false;
        }
        return true;
    }
}
