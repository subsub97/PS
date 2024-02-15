import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        int dist, index;

        Element(int d,int i) {
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

        int startV = Integer.parseInt(br.readLine().trim());

        ArrayList<Node>[] graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(w,y));
        }

        int[] dist = new int[n+1];

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[startV] = 0;

        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(0, startV));

        while(!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if(minDist != dist[minIndex]) continue;

            for (int i = 0; i < graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;
                int newDist = dist[minIndex] + targetDist;

                if(dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(newDist, targetIndex));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) {
                System.out.println("INF");
            }
            else{
                System.out.println(dist[i]);
            }
        }
    }
}