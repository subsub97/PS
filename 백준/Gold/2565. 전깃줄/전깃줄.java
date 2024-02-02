import java.util.*;
import java.io.*;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int l;
        int r;
        Eline[] eLines = new Eline[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            eLines[i] = new Eline(l, r);
        }

        Arrays.sort(eLines, new Comparator<Eline>() {
            @Override
            public int compare(Eline o1, Eline o2) {
                return o1.left - o2.left;
            }
        });

        int[] dp = new int[n];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = eLines[i].right;
            //오른쪽 전선위치 넣어줌
        }

        //오른쪽 전선의 LIS가 가장 큰 경우를 찾자

        for (int i = 0; i < n; i++) {
            if(i == 0) dp[i] = 1;
            else{
                int maxValue = 0;
                for (int j = i; j > 0 ; j--) {
                    if(arr[i] > arr[j-1]) {
                        maxValue = Math.max(maxValue, dp[j-1]);
                    }
                }
                dp[i] = maxValue + 1;
            }
        }

        int maxLis = 0;

        for (int i = 0; i < n; i++) {
            maxLis = Math.max(maxLis, dp[i]);
        }

        System.out.println(n - maxLis);

    }

    public static class Eline {
        int left;
        int right;

        Eline(int l, int r) {
            left = l;
            right = r;
        }

    }
}
