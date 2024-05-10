import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] numbers;
    static ArrayList<Integer> pair = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        selected = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(n, m);
        System.out.println(sb.toString());


    }

    static void dfs(int n, int m) {
        if(pair.size() == m) {
            for (int i = 0; i < m; i++) {
                sb.append(pair.get(i) + " ");
            }
            sb.append("\n");

        }

        for (int i = 0; i < n; i++) {
            if(selected[i]) continue;
            pair.add(numbers[i]);
            selected[i] = true;
            dfs(n, m);
            selected[i] = false;
            pair.remove(pair.size() - 1);
        }
    }
}
