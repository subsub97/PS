import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dist;
    public static ArrayList<Node>[] graph;
    static class Node implements Comparable<Node>{
        int dist;
        int vertex;

        public Node(int v, int d) {
            vertex = v;
            dist = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            //초기 설정
            graph[i] = new ArrayList<>();
            dist[i] = (int) 1e9;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int startCityNumber = Integer.parseInt(st.nextToken());
        int endCityNumber = Integer.parseInt(st.nextToken());

        getMinCost(startCityNumber);

        System.out.println(dist[endCityNumber]);
    }

    public static void getMinCost(int startCityNumber) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(startCityNumber, 0));
        dist[startCityNumber] = 0;

        while(pq.size() > 0) {
            int curCityNumber = pq.peek().vertex;
            int curCityDist = pq.peek().dist;
            pq.poll();

            if (dist[curCityNumber] != curCityDist) {
                continue;
            }

            for(int i = 0; i < graph[curCityNumber].size(); i++) {
                int nextCityNumber = graph[curCityNumber].get(i).vertex;
                int nextCityDist = graph[curCityNumber].get(i).dist;

                int newDist = nextCityDist + dist[curCityNumber];

                if(newDist < dist[nextCityNumber]) {
                    dist[nextCityNumber] = newDist;
                    pq.add(new Node(nextCityNumber,newDist));
                }
            }
        }
    }
}
