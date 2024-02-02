import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weights = new int[100_001];
        int[] values = new int[100_001];
        int[][] dp = new int[n+1][100_001];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < 100001; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 100_001; j++) {
                if(j < weights[i-1] || j - weights[i-1] < 0 || dp[i-1][j-weights[i-1]] == -1) {
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i - 1]] + values[i - 1], dp[i - 1][j]);
                }
            }
        }


        System.out.print(dp[n][k]);

    }
}