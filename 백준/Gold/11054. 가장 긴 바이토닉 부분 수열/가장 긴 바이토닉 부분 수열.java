import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ascLis = new int[n];
        int[] descLis = new int[n];

        ascLis[0] = 1;
        descLis[n-1] = 1;

        for (int i = 1; i < n; i++) {
            ascLis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && ascLis[i] < ascLis[j] + 1) {
                    ascLis[i] = ascLis[j] + 1;
                }
            }
        }

        for (int i = n-2; i >= 0 ; i--) {
            descLis[i] = 1;
            for (int j = n-1; j > i ; j--) {
                if (arr[j] < arr[i] && descLis[i] < descLis[j] + 1) {
                    descLis[i] = descLis[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, ascLis[i] + descLis[i] - 1);
        }

        System.out.println(max);
    }
}
