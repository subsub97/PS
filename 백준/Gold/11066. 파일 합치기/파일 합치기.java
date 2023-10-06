import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T= Integer.parseInt(st.nextToken());

        for(int i = 0; i <T; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            StringTokenizer stn = new StringTokenizer(br.readLine());

            int[] novel = new int[n+1];
            int[][] dp = new int[n+1][n+1]; //i 페이지부터 j 페이지까지 누적합을 기록하기 위함
            int[] sum = new int[n+1]; // 누적합 계산을 위한 배열


            for(int j = 1; j <= n; j++) {
                novel[j] = Integer.parseInt(stn.nextToken()); // 원본 소설 파일크기 저장
                sum[j] = novel[j] + sum[j-1];
            }
            for(int k = 1; k<=n;k++ ) {
                for(int from = 1; from+k <= n; from++) { //from 부터 to까지
                    int to = from +k;
                    dp[from][to] = 100000000;
                    for(int divide = from; divide < to; divide++) {
                        dp[from][to] =Math.min(dp[from][to],dp[from][divide] + dp[divide+1][to] + sum[to] -sum[from-1]);
                    }
                }
            }
            System.out.println(dp[1][n]);
        }

    }
}

// 오랜시간 고민하다가 해결하지 못해서 https://guy-who-writes-sourcecode.tistory.com/43 를 참고해서 풀었다.