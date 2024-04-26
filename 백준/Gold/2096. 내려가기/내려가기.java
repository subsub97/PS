import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n][3];
        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        // 최대 찾기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0) {
                    //위, 대각위만 가능한 경우
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j+1]) + arr[i][j];
                    continue;
                }

                else if(j == 2) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j + 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1])) + arr[i][j];

            }
        }

        int maxValue = 0;

        for (int i = 0; i < 3; i++) {
            maxValue = Math.max(dp[n-1][i], maxValue);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0) {
                    //위, 대각위만 가능한 경우
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + arr[i][j];
                    continue;
                }

                else if(j == 2) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j + 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + arr[i][j];

            }
        }


        int minValue = (int) 1e9;

        for (int i = 0; i < 3; i++) {
            minValue = Math.min(dp[n-1][i], minValue);
        }


        System.out.print(maxValue +" ");
        System.out.print(minValue);
    }

}
