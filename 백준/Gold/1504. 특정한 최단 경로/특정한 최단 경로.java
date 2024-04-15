import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Element>[] graph;
    public static int[][] dist;
    static class Element implements Comparable<Element> {
        int dist;
        int index;

        public Element(int i, int d) {
            dist = d;
            index = i;
        }

        @Override
        public int compareTo(Element element) {
            return this.dist - element.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][3];
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i][0] = (int) 1e9;
            dist[i][1] = (int) 1e9;
            dist[i][2] = (int) 1e9;
        }

        for (int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[start].add(new Element(end, dist));
            graph[end].add(new Element(start, dist));
        }

        st = new StringTokenizer(br.readLine());

        int passIndex1 = Integer.parseInt(st.nextToken());
        int passIndex2 = Integer.parseInt(st.nextToken());

        int minCost = Integer.MAX_VALUE;
        int tempSum = 0;


        getMinCost(1,0); // 1에서 각 정점까지 거리
        getMinCost(passIndex1,1); // 첫번째 경유지에서 각 정점까지 거리
        getMinCost(passIndex2,2); // 두번째 거리에서 각 정점까지 거리

        tempSum += dist[passIndex1][0];
        tempSum += dist[passIndex2][1];
        tempSum += dist[n][2];

        minCost = Math.min(tempSum, minCost);

        tempSum = 0;
        tempSum += dist[passIndex2][0]; // 1 -> 2번쨰 경유지
        tempSum += dist[passIndex1][2]; // 2번째 경유지에서 -> 1번 경유지
        tempSum += dist[n][1]; // 1번 경유지에서 -> n

        minCost = Math.min(tempSum, minCost);

        if(minCost >= (int) 1e9 || minCost < 0 ){
            System.out.println(-1);
        }
        else{
            System.out.println(minCost);
        }

    }

    public static void getMinCost(int startIndex,int number) {
        PriorityQueue<Element> pq = new PriorityQueue<>();

        pq.add(new Element(startIndex, 0));
        dist[startIndex][number] = 0;

        while(pq.size() > 0) {
            int curIdx = pq.peek().index;
            int curDist = pq.peek().dist;
            pq.poll();

            if(curDist != dist[curIdx][number]) continue;

            for (int i = 0; i < graph[curIdx].size(); i++) {
                int nextIdx = graph[curIdx].get(i).index;
                int nextDist = graph[curIdx].get(i).dist;

                int newDist = nextDist + dist[curIdx][number];

                if(newDist < dist[nextIdx][number]) {
                    dist[nextIdx][number] = newDist;
                    pq.add(new Element(nextIdx, newDist));
                }
            }
        }
    }
}
