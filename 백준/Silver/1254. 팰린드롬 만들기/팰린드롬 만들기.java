import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int answer = getMinPalindrome(word);

        System.out.println(answer);

    }

    public static int getMinPalindrome(String word) {
        int minValue = 0;

        for (int i = 0; i < word.length(); i++) {
            String curWord = word.substring(i, word.length());
            if (checkPalindrome(curWord)) {
                minValue = i;
                break;
            }
        }

        return minValue + word.length();

    }

    public static boolean checkPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        for (int i = 0; i < word.length() / 2; i++) {
            if(word.charAt(left+i) != word.charAt(right-i)) {
                return false;
            }
        }

        return true;
    }
}
