import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int answer = 0;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new int[n];

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if(depth == n) {
            answer++;
            return;
        }

        for(int i = 0 ; i < n; i++) {
            visited[depth] = i;
            if(canPosition(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean canPosition(int col) {
        for(int i = 0 ; i < col ; i++) {

            if(visited[i]==visited[col]) {
                return false;
            }

            else if(Math.abs(col-i) == Math.abs(visited[col]-visited[i])) {
                return false;
            }

        }

        return true;
    }
}
