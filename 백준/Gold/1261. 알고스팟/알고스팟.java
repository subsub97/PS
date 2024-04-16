import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(a.substring(j,j+1));
            }
        }

        int answer = bfs();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(0);
        }

        else{
            System.out.println(answer);
        }



    }

    public static int bfs() {
        PriorityQueue<Info> q = new PriorityQueue<>();

        q.add(new Info(0, 0, 0));
        visited[0][0] = true;
        int minbreakCount = Integer.MAX_VALUE;

        int[] drs = {1, -1, 0, 0};
        int[] dcs = {0, 0, -1, 1};

        while(q.size() > 0){
            Info curInfo = q.poll();

            if(curInfo.row == m-1 && curInfo.col == n-1){
                // 목적지
                minbreakCount = Math.min(minbreakCount, curInfo.breakConunt);
                return minbreakCount;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = curInfo.row + drs[i];
                int nextCol = curInfo.col + dcs[i];

                if(inRange(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                    //범위 이내라면

                    if(grid[nextRow][nextCol] == 1) {
                        // 벽이 있는 경우
                        q.add(new Info(nextRow, nextCol, curInfo.breakConunt + 1));
                        visited[nextRow][nextCol] = true;
                        continue;
                    }

                    q.add(new Info(nextRow, nextCol, curInfo.breakConunt));
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return minbreakCount;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }


    static class Info implements Comparable<Info>{
        int row;
        int col;
        int breakConunt;

        public Info(int r, int y, int bc) {
            row = r;
            col = y;
            breakConunt = bc;
        }

        @Override
        public int compareTo(Info o1) {
            return this.breakConunt - o1.breakConunt;
        }
    }
}
