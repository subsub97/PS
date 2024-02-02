import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] wordA = br.readLine().toCharArray();
        char[] wordB = br.readLine().toCharArray();

        int maxLength = Math.max(wordA.length, wordB.length);
        int minLength = Math.min(wordA.length, wordB.length);
        int[][] dp = new int[maxLength + 1][maxLength + 1];

        for (int i = 1; i <= wordA.length; i++) {
            for (int j = 1; j <= wordB.length ; j++) {
                if(wordA[i-1] == wordB[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < maxLength+1; i++) {
            for (int j = 0; j < maxLength+1; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}