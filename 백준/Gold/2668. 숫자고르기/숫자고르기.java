import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int answer = 0;
    static int[] arr;
    static boolean[] checked;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        checked = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            if(!checked[i]) {
                visited[i] = true;
                dfs(i, i);
            }
        }

        System.out.println(answer);

        for (int i = 1; i <= n; i++) {
            if(checked[i]) System.out.println(i);
        }


    }

    public static void dfs(int curVertex, int startVertex) {

        int nextVertex = arr[curVertex];

        if(nextVertex == startVertex) {
            visited[nextVertex] = true;
            makeSet();
        }

        else {
            if (!visited[nextVertex]) {
                visited[nextVertex] = true;
                dfs(nextVertex,startVertex);
            }
        }
    }

    public static void makeSet() {
        for (int i = 0; i <= n; i++) {
            if(visited[i]) {
                answer++;
                checked[i] = true;
            }
        }
    }
}
