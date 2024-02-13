import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_SELECT = 3;
    public static int n, m,maxSafeSize;
    public static int[][] grid;
    public static boolean[][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static ArrayList<Pair> selected = new ArrayList<>();
    public static ArrayList<Pair> emptyPair = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

        maxSafeSize = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 2) {
                    //바이러스가 확산되는 시점
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 0) {
                    emptyPair.add(new Pair(i, j));
                }
            }
        }

        choose(0,0);

        System.out.println(maxSafeSize);
    }
    public static void choose(int idx ,int cnt) {
        if(cnt == MAX_SELECT) {
            //시뮬 ㄱ
            simulate();
            return;
        }

        for (int i = idx; i < emptyPair.size(); i++) {
            selected.add(emptyPair.get(i));
            choose(i+1,cnt+1);
            selected.remove(selected.size() -1);
        }
    }

    public static void bfs() {
        int[] drs = {1, -1, 0, 0};
        int[] dcs = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            visited[p.row][p.col] = true;

            for (int i = 0; i < 4; i++) {
                int nR = p.row + drs[i];
                int nC = p.col + dcs[i];

                if(canInfection(nR,nC)) {
                    visited[nR][nC] = true;
                    q.add(new Pair(nR, nC));
                }
            }
        }
    }

    public static int checkSize() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void findStrtPair() {
        if (q.size() == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(grid[i][j] == 2) {
                        q.add(new Pair(i, j));
                    }
                }
            }
        }
    }

    public static void initVisited() {
        visited = new boolean[n][m];
    }

    public static void simulate() {
        initVisited();

        for(Pair p: selected) {
            // 벽 세우기
            grid[p.row][p.col] = 1;
        }

        findStrtPair();
        bfs();
        int size = checkSize();

        maxSafeSize = Math.max(size, maxSafeSize);

        for(Pair p: selected) {
            // 벽 지우기
            grid[p.row][p.col] = 0;
        }

    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static boolean canInfection(int r, int c) {
        if(!inRange(r,c)) return false;
        if(grid[r][c] == 1 || visited[r][c]) return false;
        return true;
    }

    public static class Pair {
        int row,col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }
}