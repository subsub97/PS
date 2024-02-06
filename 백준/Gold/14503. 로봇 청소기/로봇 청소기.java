import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];
        // 처음 로봇 청소기가 있는 좌표 r,c
        int r,c,d;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = startCleanBot(r, c, d);
        System.out.println(ans);
    }

    public static int startCleanBot(int row, int col ,int dir) {
        int cnt = 0;

        while (true) {
            if(grid[row][col] == 0 && !visited[row][col]) {
                cnt++;
                visited[row][col] = true;
            }
            // 상,우,하,좌
            int[] drs = {-1,0,1,0};
            int[] dcs = {0,1,0,-1};


            if(!checkCleanSpot(row,col)) {
                // 주변에 청소가능한 곳이 없는 경우 -> 후진
                row += drs[(dir + 2) % 4];
                col += dcs[(dir + 2) % 4];
                if(!inRange(row,col) || grid[row][col] == 1) {
                    //후진할 때 벽이라면 작동을 멈춤
                    break;
                }
            }
            else{
                //정면은 아니지만 청소 가능한 구역이 있는 경우
                dir = dir - 1;
                if(dir < 0) {
                    dir = 3;
                }

            }
            if(canFacedSpotClean(row + drs[dir],col + dcs[dir])) {
                // 바라보는 방향이 청소 해야하는 경우
                row = row + drs[dir];
                col = col + dcs[dir];
            }
        }

        return cnt;

    }

    public static boolean canFacedSpotClean(int row,int col) {
        if(canGo(row,col) && !visited[row][col]) {
            return true;
        }
        return false;
    }

    public static boolean checkCleanSpot(int row, int col) {
        int[] drs = {-1,0,1,0};
        int[] dcs = {0,1,0,-1};

        int dir = 0;

        for (int i = 0; i < 4; i++) {
            int nextR = row + drs[dir];
            int nextC = col + dcs[dir++];
            if(canGo(nextR,nextC)) {
                //청소 가능 구역이 있는 경우
                return true;
            }
        }

        return false;
    }

    public static boolean inRange(int row, int col) {
        return row >=0 && row < n && col >= 0 && col <m;
    }

    public static boolean canGo(int row, int col) {
        if(!inRange(row,col)) {
            return false;
        }
        if(grid[row][col] == 1) {
            return false;
        }
        if(visited[row][col]){
            return false;
        }
        return true;
    }
}
