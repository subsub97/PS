import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static final String FAIL_STRING = "I'm Sorry Hansoo";
    public static final int OFFSET = 65;
    public static boolean flag = false;
    public static char[] answer;
    public static int[] alpaCount = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        answer = new char[name.length()];
        name = name.toUpperCase(Locale.ROOT);

        for (int i = 0; i < name.length(); i++) {
            char curAlpa = name.charAt(i);
            alpaCount[(int)curAlpa - OFFSET]++;
        }

        makeLoveLetter();
        if(answer.length == 1){
            answer[0] = name.charAt(0);
        }

        if (flag && answer.length != 1) {
            System.out.print(FAIL_STRING);
        }

        else{
            for (char c : answer) {
                System.out.print(c);
            }
        }

    }

    public static void makeLoveLetter() {
        int leftPointer = 0;
        int rightPointer = answer.length - 1;
        boolean isValid = false;

        for (int i = 0; i < 26; i++) {
            // A부터 사용하면서 팬린드롬 수 만들기
            while(alpaCount[i] > 1) {
                //현재 사용하려는 알파벳이 2개 이상인 경우
                //왼쪽에하나 맨 오른쪽에 하나 넣어줌
                alpaCount[i] -= 2;
                answer[leftPointer++] = (char)(i + OFFSET);
                answer[rightPointer--] = (char)(i + OFFSET);
            }

            if(alpaCount[i] == 1) {
                if(answer.length / 2 == 0){
                    flag = true;
                    return;
                }
                if(isValid) {
                    flag = true;
                    return;
                }
                isValid = true;
                answer[answer.length / 2] = (char)(i + OFFSET);
            }

        }
    }

}
