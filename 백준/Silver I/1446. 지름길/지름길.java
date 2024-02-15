import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        int dist,index;

        Node(int d, int i) {
            dist = d;
            index = i;
        }
    }

    public static class Element implements Comparable<Element> {
        int dist,index;

        Element(int d, int i) {
            dist = d;
            index = i;
        }

        @Override
        public int compareTo(Element e) {
            return this.dist - e.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph =  new ArrayList[m+1];

        for (int i = 0; i <= m; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i <= m; i++) {
            graph[i].add(new Node(1,i+1)); // 자신보다 1 높은 곳인 비용 1로 갈 수 있는 간선 추가
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(e <= m) // 도달해야하는 범위 이내라면
                graph[s].add(new Node(w,e)); // w의 가중치를 가진 s -> e 간선 추가
        }

        int[] dist = new int[m+1];

        for (int i = 0; i <= m; i++) {
            dist[i] = (int)1e9;
        }

        dist[0] = 0; // 시작 위치 값 0으로 설정

        PriorityQueue<Element> pq = new PriorityQueue<>();

        pq.add(new Element(0, 0));

        while(!pq.isEmpty()) {
            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;

            pq.poll();

            if(minDist != dist[minIndex]) continue;

            for (int i = 0; i < graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;
                if(targetIndex > m) continue;
                int newDist = dist[minIndex] + targetDist;

                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        System.out.println(dist[m]);

    }
}