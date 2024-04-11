import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n,m;
    public static boolean flag;
    public static boolean[] cycles;
    public static int[][] grid;
    public static int[] teamNumbers;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 0;

        while(true) {
            test++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m ==0) {
                break;
            }

            grid = new int[n + 1][n + 1];
            teamNumbers = new int[n + 1];
            cycles = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                teamNumbers[i] = i;
            }

            visited = new boolean[n + 1];
            int treeCnt = 0;


            for(int i = 0; i < m; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st1.nextToken());
                int col = Integer.parseInt(st1.nextToken());

                int x = find(row);
                int y = find(col);

                if(x == y) {
                    cycles[x] = true;
                }

                if(x < y) {
                    teamNumbers[y] = x;

                }
                else{
                    teamNumbers[x] = y;
                }

                grid[row][col] = 1;
                grid[col][row] = 1;
            }

            for (int i = 1; i <= n; i++) {


                if(visited[i]) continue;
                flag = false;
                dfs(i);
                if(!flag) treeCnt++;

            }


            if(treeCnt == 0) {
                System.out.println("Case" + " " + test + ": No trees.");
            } else if (treeCnt == 1) {
                System.out.println("Case" + " " + test + ": There is one tree.");
            }

            else{
                System.out.println("Case" + " " + test + ": A forest of " + treeCnt + " trees.");
            }
        }
    }

    public static int find(int x) {
        if(teamNumbers[x] == x) {
            return x;
        }
        return teamNumbers[x] = find(teamNumbers[x]);
    }

    public static void dfs(int v) {
        visited[v] = true;
        if(cycles[v]) flag = true;

        for (int i = 1; i <= n; i++) {
            if(grid[v][i] != 0 && !canGO(i)) {
                dfs(i);
            }
        }
    }



    public static boolean canGO(int i) {
        return visited[i];
    }
}