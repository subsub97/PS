import java.io.*;
import java.util.*;

public class Main {
    public static int n, m,minPath;
    public static int[][] grid;
    public static boolean[][][] visited;
    public static Queue<Pair> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m][2];
        minPath = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }

        q.add(new Pair(0, 0, 1));
        bfs();

        if(minPath == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(minPath);
        }


    }

    public static void bfs() {
        int[] drs = {1, 0, -1, 0};
        int[] dcs = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if(p.distance > minPath)
                break;
            if(p.row == n-1 && p.col == m-1) {
                // 목적지에 도달한 경우
                minPath = Math.min(p.distance, minPath);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nR = p.row + drs[i];
                int nC = p.col + dcs[i];

                if(canBreak(nR,nC) && p.canBreak){
                    // 부수고 갈 수 있는 경우
                    q.add(new Pair(nR,nC,p.distance+1,false));
                    visited[nR][nC][1] = true;
                }

                if(canGo(nR,nC,p)){
                    q.add(new Pair(nR, nC, p.distance + 1,p.canBreak));
                    if(p.canBreak == false) {
                        visited[nR][nC][1] = true;
                    }
                    else{
                        visited[nR][nC][0] = true;
                    }

                }
            }
        }
    }


    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n  && c >= 0 && c < m;
    }

    public static boolean canBreak(int r, int c) {
        if(!inRange(r,c)) return false;
        if(grid[r][c] == 0 || visited[r][c][1]) return false;
        return true;
    }

    public static boolean canGo(int r,int c,Pair p) {
        if(!inRange(r,c)) return false;
        if(p.canBreak == false && visited[r][c][1]) return false;
        if(grid[r][c] == 1 || visited[r][c][0]) return false;
        return true;
    }


    public static class Pair {
        int row,col,distance;
        boolean canBreak = true;

        Pair(int r, int c, int d) {
            row = r;
            col = c;
            distance = d;
        }
        Pair(int r,int c,int d,boolean br) {
            this(r,c,d);
            canBreak = br;
        }
    }
}

