import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int T,n,m;
    public static int[][] grid;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); //가로
            n = Integer.parseInt(st.nextToken()); // 세로
            int k = Integer.parseInt(st.nextToken());

            grid = new int[n][m]; //배추밭 그리기
            visited = new boolean[n][m];

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken()); // 가로
                int row = Integer.parseInt(st.nextToken());

                grid[row][col] = 1; // 배추 심기
            }
            int cnt = 0;
            for(int j = 0; j < n; j++){
                for(int l = 0; l < m; l++) {
                    if(!visited[j][l] && grid[j][l] == 1) {
                        // 지렁이가 없는 배추밭 구역인 경우
                        dfs(j,l);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        int[] drs = {1,-1,0,0};
        int[] dcs = {0,0,1,-1};

        for(int i = 0; i < 4; i++) {
            int nR = r + drs[i];
            int nC = c + dcs[i];

            if (canMove(nR, nC)) {
                //지렁이가 이동 가능한 경우라면
                dfs(nR,nC);
            }
        }


    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static boolean canMove(int r, int c) {
        if(!inRange(r,c)) return false;
        if(grid[r][c] == 0 || visited[r][c]) return false;
        return true;
    }
}