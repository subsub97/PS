import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n,x;
    public static int[] numbers;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int leftIdx = 0;
        int rightIdx = n-1;
        int answer = 0;

        while(leftIdx < rightIdx) {
            int curSum = numbers[leftIdx] + numbers[rightIdx];

            if(curSum == x) {
                answer++;
            }

            if(curSum > x) {
                rightIdx--;
            }
            else{
                leftIdx++;
            }
        }

        System.out.println(answer);

    }
}