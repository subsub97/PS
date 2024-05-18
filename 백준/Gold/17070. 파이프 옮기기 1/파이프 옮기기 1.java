import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, answer;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        answer = 0;

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(answer);

    }

    public static void dfs(int r, int c, int dir) {
        if(r == n-1 && c == n-1) {
            answer++;
            return;
        }
        // dir이 0 : 가로, 1 : 세로 , 2 :대각
        int[][] dirs = {{1,0},{0,1},{1,1}};
        for (int i = 0; i < dirs.length; i++) {
            if(dir == i && dir != 2) continue;
            int nextR = r + dirs[i][0];
            int nextC = c + dirs[i][1];
            if (canConnect(nextR, nextC, i)) {
                int nextDir = i;
                if(i == 0) nextDir = i + 1;
                if(i == 1) nextDir = i - 1;
                dfs(nextR, nextC, nextDir);
            }
        }
    }
    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static boolean canConnect(int r, int c, int dir) {
        if(!inRange(r, c)) return false;
        //벽확인하기
        if(grid[r][c] == 1) return false;
        //대각인 경우
        if(dir == 2) {
            if(grid[r-1][c] == 1) return false;
            if(grid[r][c-1] == 1) return false;
        }
        return true;
    }
}
