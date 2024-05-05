import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,answer;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j,grid[i][j],1);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int r, int c,int sum,int depth) {
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        int[] drs = {1, 0, -1, 0};
        int[] dcs = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nextR = drs[i] + r;
            int nextC = dcs[i] + c;

            if(!inRange(nextR, nextC) || visited[nextR][nextC]) continue;

            if(depth == 2) {
                visited[nextR][nextC] = true;
                dfs(r, c, sum + grid[nextR][nextC], depth + 1);
                visited[nextR][nextC] = false;
            }
            visited[nextR][nextC] = true;
            dfs(nextR,nextC,sum + grid[nextR][nextC], depth + 1);
            visited[nextR][nextC] = false;
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
