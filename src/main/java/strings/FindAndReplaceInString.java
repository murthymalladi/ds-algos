package strings;

/**
 * Created by dmalladi on 12/30/2019.
 */
public class FindAndReplaceInString {
    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            String source = sources[i];
            String target = targets[i];
            sb.append(S.substring(prev,index));
            if (S.substring(index,index+source.length()).equals(source)) {

                sb.append(target);
                prev = index+source.length();
            }
            else {
                prev = index;
            }

        }
        if (prev < S.length()) {
            sb.append(S.substring(prev,S.length()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = {0,2};
        String[] sources = {"ab","ec"};
        String[] targets = {"eee","ffff"};

        String replacementString =  findReplaceString(S,indexes,sources,targets);
        System.out.println(replacementString);
    }
}
