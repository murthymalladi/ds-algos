package strings;

/**
 * Created by dmalladi on 11/10/2018.
 */
public class MultiplyNumbers {

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        System.out.println(multiply(s1,s2));
    }

    public static String multiply(String num1,String num2) {
        int[] product = new int[num1.length()+num2.length()];

        for (int i = num1.length()-1; i >=0 ;i--) {
            int first = num1.charAt(i) - '0';
            for (int j = num2.length()-1; j>=0 ;j--) {

                int second = num2.charAt(j) - '0';
                product[i+j+1] += first*second;
                product[i+j] += product[i+j+1]/10;
                product[i+j+1] %= 10;
           }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < product.length; i++)
             sb.append(product[i]);

        return sb.toString();
    }
}
