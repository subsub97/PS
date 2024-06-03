import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        String bombWord = br.readLine();

        StringBuilder answer = doExplore(sentence, bombWord);
        if (answer.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer.toString());
        }
    }

    public static StringBuilder doExplore(String sentence, String bombWord) {
        StringBuilder result = new StringBuilder();
        int bombLength = bombWord.length();

        for (int i = 0; i < sentence.length(); i++) {
            result.append(sentence.charAt(i));

            if (result.length() >= bombLength) {
                boolean isBomb = true;
                for (int j = 0; j < bombLength; j++) {
                    if (result.charAt(result.length() - bombLength + j) != bombWord.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    result.delete(result.length() - bombLength, result.length());
                }
            }
        }
        return result;
    }
}