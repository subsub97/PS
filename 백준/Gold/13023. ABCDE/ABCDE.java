import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int visitedCnt = 1;
    static boolean flag = false;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        visited = new boolean[n];


        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 0; i < n; i++) {
            if (flag) {
                break;
            }

            visited = new boolean[n];

            dfs(i);
        }

        if (!flag) {
            System.out.println(0);
        }
        else{
            System.out.println(1);
        }
    }

    public static void dfs(int curIdx) {
        if(flag) return;

        if(visitedCnt == 5) {
            flag = true;
            return;
        }

        visited[curIdx] = true;

        for(int i = 0; i < graph[curIdx].size(); i++) {
            int next = graph[curIdx].get(i);

            if(!visited[next]) {
                visitedCnt++;
                dfs(next);
                visited[next] = false;
                visitedCnt--;
            }
        }
    }
}
