package patterns.binarysearch;

/**
 * Created by dmalladi on 10/3/2019.
 */
public class NextLetter {
    public static char searchNextLetter(char[] letters, char key) {
        // TODO: Write your code here
        int start = 0;
        int end = letters.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if (letters[mid] <= key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return letters[start%letters.length];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
