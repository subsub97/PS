import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n-1; i > -1 ; i--) {
            int curNumber = numbers[i]; //현재 기준으로 정한 수

            while(!stack.isEmpty() && stack.peek() <= curNumber) {
                //현재 비교할 스택이 비어있지 않고 기준 숫자가 더 큰 경우
                 stack.pop();
            }

            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(curNumber);
        }

        for (int i = 0; i < n; i++) {
            bw.write(ans[i] +" ");
        }
        bw.close();
    }
}
