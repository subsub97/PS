import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,x;
    static ArrayList<Node>[] graph;
    static int[] dist;

    static class Node implements Comparable<Node>{
        int cost;
        int vertex;

        Node(int e, int c) {
            cost = c;
            vertex = e;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        int[] eachElapsedTime = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if(i == x) {
                continue;
            }

            // i -> x 도착지 최소 거리 구하기
            dijkstra(i);

            eachElapsedTime[i] = dist[x];
        }

        // x -> i 최소 구하기
        dijkstra(x);

        for (int i = 1; i <=n ; i++) {
            if(x == i) continue;
            eachElapsedTime[i] += dist[i];
        }

        int maxTime = 0;

        for (int i = 0; i <= n; i++) {
            maxTime = Math.max(maxTime, eachElapsedTime[i]);
        }

        System.out.println(maxTime);
    }

    public static void dijkstra(int startVertex) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }
        pq.add(new Node(startVertex, 0));
        dist[startVertex] = 0;
        //정점에서 가장 가까운 노드에 방문한다.

        while(pq.size() > 0) {
            int curVertex = pq.peek().vertex;
            int curCost = pq.peek().cost;
            pq.poll();

            if(dist[curVertex] != curCost) continue;

            //최신 노드인 경우
            for (int i = 0; i < graph[curVertex].size(); i++) {
                int nextVertex = graph[curVertex].get(i).vertex;
                int nextCost = graph[curVertex].get(i).cost;

                int newDist = dist[curVertex] + nextCost;

                if(newDist < dist[nextVertex]) {
                    dist[nextVertex] = newDist;
                    pq.add(new Node(nextVertex, newDist));
                }

            }
        }
    }
}
