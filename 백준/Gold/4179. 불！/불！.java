import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, ans;
    public static char[][] grid;
    public static boolean[][] fVisited;
    public static boolean[][] visited;
    public static int[][] timeTable;
    public static Queue<Pair> q = new LinkedList<>();

    public static class Pair {
        int row, col, time, con;

        Pair() {
            row = 0;
            col = 0;
        }

        Pair(int r, int c, int t, int co) {
            row = r;
            col = c;
            time = t;
            con = co;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        visited = new boolean[n][m];
        fVisited = new boolean[n][m];
        timeTable = new int[n][m];

        Pair ji = new Pair();
        boolean a = false;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'J') {
                    ji.row = i;
                    ji.col = j;
                    ji.time = 1;
                    ji.con = 1;
                    a = true;

                }
                if (grid[i][j] == 'F') {
                    fVisited[i][j] = true;
                    q.add(new Pair(i, j, 1, 2));
                }

            }
        }
        if(a) q.add(ji);

        visited[ji.row][ji.col] = true;
        ans = -1;
        bfs();

        q = new LinkedList<>();


        if (ans == -1) {
            System.out.print("IMPOSSIBLE");
        }
        else {
            System.out.println(ans);
        }


    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static boolean canMove(int r, int c) {
        if (!inRange(r, c))
            return false;
        if (visited[r][c] || grid[r][c] == '#' || grid[r][c] == 'F')
            return false;
        return true;
    }

    public static boolean canfMove(int r, int c) {
        if (!inRange(r, c))
            return false;
        if (fVisited[r][c] || grid[r][c] == '#')
            return false;
        return true;
    }

    public static void bfs() {
        int[] drs = {1, -1, 0, 0};
        int[] dcs = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.con == 2) {

                //불인 경우
                for (int i = 0; i < 4; i++) {
                    int nR = p.row + drs[i];
                    int nC = p.col + dcs[i];

                    if (canfMove(nR, nC)) {
                        fVisited[nR][nC] = true;
                        grid[nR][nC] = 'F';
                        q.add(new Pair(nR, nC, p.time + 1, 2));
                    }
                }

            } else {
                //지성이인 경우
                if (p.row == n - 1 || p.row == 0 || p.col == 0 || p.col == m - 1) {
                    ans = p.time;
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    //지성이 움직이기
                    int nR = p.row + drs[i];
                    int nC = p.col + dcs[i];

                    if (canMove(nR, nC)) {
                        visited[nR][nC] = true;
                        q.add(new Pair(nR, nC, p.time + 1, 1));
                        if (nR == n - 1 || nR == 0 || nC == 0 || nC == m - 1) {
                            ans = p.time + 1;
                            return;
                        }
                    }

                }
            }
        }

    }
}