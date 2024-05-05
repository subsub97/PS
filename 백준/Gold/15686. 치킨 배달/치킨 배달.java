import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m, minDistance, storeCount;

    static int[][] chickenMap;
    static boolean[] visited;
    static ArrayList<Pair> houses = new ArrayList<>();
    static ArrayList<Pair> stores = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        minDistance = Integer.MAX_VALUE;

        chickenMap = new int[n][n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                chickenMap[i][j] = Integer.parseInt(st.nextToken());
                if(chickenMap[i][j] == 2) {
                    stores.add(new Pair(i,j,0));
                    storeCount++;
                } else if (chickenMap[i][j] == 1) {
                    houses.add(new Pair(i, j, 0));
                }
            }
        }

        visited = new boolean[storeCount];
        dfs(0);
        System.out.println(minDistance);

    }

    public static void simulate() {
        int sum = 0;
        // 현재 각 치킨거리 계산하기
        for (Pair house : houses) {
            int minDis = 10000000;
            for (int i = 0; i <stores.size() ; i++) {
                if(visited[i]) continue;
                minDis = Math.min(Math.abs(house.row - stores.get(i).row) + Math.abs(house.col - stores.get(i).col),minDis);
            }
            sum += minDis;
        }
        // 도시치킨거리 갱신하기
        minDistance = Math.min(sum, minDistance);
    }

    public static void dfs(int start) {
        if(storeCount <= m) {
            simulate();
            return;
        }

        for(int i = start; i < stores.size(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            storeCount--;
            dfs(i + 1);
            storeCount++;
            visited[i] = false;
        }
    }

    static class Pair {
        int row;
        int col;
        int cost;

        Pair(int r, int c, int cost) {
            row = r;
            col = c;
            this.cost = cost;
        }
    }



}
