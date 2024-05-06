import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,maxCost;
    static int node;
    static ArrayList<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];


        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));
        }
        
        node = 1;
        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);


        System.out.println(maxCost);
    }

    public static void dfs(int v,int costSum) {
        visited[v] = true;

        if (costSum > maxCost) {
            maxCost = costSum;
            node = v;
        }

        for (int i = 0; i < graph[v].size(); i++) {
            Node nextNode = graph[v].get(i);
            if(visited[nextNode.vertex]) continue;

            dfs(nextNode.vertex, costSum + nextNode.cost);
        }
    }

    static class Node{
        int vertex;
        int cost;

        Node(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }
    }
}
