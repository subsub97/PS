import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,answer;
    static int[][] map;
    static boolean[][] visited;
    static boolean[] isUsed;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        isUsed = new boolean[27];
        answer = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = (int)s.charAt(j) - 65;
            }
        }

        visited[0][0] = true;
        isUsed[map[0][0]] = true;
        dfs(0,0,1);

        System.out.println(answer);


    }

    public static void dfs(int r, int c,int depth) {
        int[] drs = new int[]{-1, 1, 0, 0};
        int[] dcs = new int[]{0, 0, -1, 1};
        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int newRow = r + drs[i];
            int newCol = c + dcs[i];

            if(canMove(newRow, newCol)) {
                visited[newRow][newCol] = true;
                isUsed[map[newRow][newCol]] = true;
                dfs(newRow, newCol,depth + 1);
                visited[newRow][newCol] = false;
                isUsed[map[newRow][newCol]] = false;
                }
            }
    }


    public static boolean inRange(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    public static boolean canMove(int row, int col) {
        if(!inRange(row, col)) return false;
        if(visited[row][col]) return false;
        if(isUsed[map[row][col]]) return false;
        return true;
    }
}

