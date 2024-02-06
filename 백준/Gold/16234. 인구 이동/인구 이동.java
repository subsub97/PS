import java.util.*;
import java.io.*;

public class Main {
    public static int n,L,R;
    public static int[][] world;
    public static boolean[][] visited;
    public static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        world = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while(true) {
            visited = new boolean[n][n];
            temp = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        // 아직 체크되지 않은 경우
                        canMerge(i,j);
                    }
                }
            }
            if(!merge()) {
                System.out.println(ans);
                break;
            }
            ans++;
        }


    }

    public static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static boolean checkMerge(int r, int c, int nextR, int nextC) {
        return Math.abs(world[r][c] - world[nextR][nextC]) >= L && Math.abs(world[r][c] - world[nextR][nextC]) <= R;
    }

    public static void canMerge(int row, int col) {
        int[] drs = {1, -1, 0, 0};
        int[] dcs = {0, 0, -1, 1};

        Queue<Country> q = new LinkedList<>();
        Queue<Country> afterQ = new LinkedList<>();

        q.add(new Country(row, col));

        int population = 0;

        while(!q.isEmpty()) {

            Country country = q.poll();
            if(visited[country.row][country.col]) {
                //이미 방문된 곳 이라면 skip
                continue;
            }

            visited[country.row][country.col] = true;


            int curR = country.row;
            int curC = country.col;
            population += world[curR][curC];
            afterQ.add(new Country(curR, curC));

            int dir = 0;

            for (int i = 0; i < 4; i++) {
                int nextR = curR + drs[dir];
                int nextC = curC + dcs[dir];
                dir++;

                if (inRange(nextR, nextC) && !visited[nextR][nextC] && checkMerge(curR,curC,nextR,nextC)) {
                    //유효한 범위에 방문하지 않은 연합 가능한 국가가 있다면
                    q.add(new Country(nextR, nextC));
                }
            }
        }

        if(afterQ.size() > 1) {
            int size = afterQ.size();

            while(!afterQ.isEmpty()) {
                // merge 가능한 곳의 인구 수 분배
                Country country = afterQ.poll();
                int r = country.row;
                int c = country.col;

                temp[r][c] = population / size;
            }
        }

    }

    public static boolean merge() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(temp[i][j] != 0) {
                    world[i][j] = temp[i][j];
                    cnt++;
                }
            }
        }

        if(cnt > 0) {
            return true;
        }
        return false;
    }

    public static class Country {
        int row;
        int col;

        Country(int r, int c) {
            row = r;
            col = c;
        }
    }
}
