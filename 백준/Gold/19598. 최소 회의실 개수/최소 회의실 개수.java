import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static PriorityQueue<room> pq = new PriorityQueue<>();
    static class room implements Comparable<room> {
        public int startTime;
        public int endTime;

        public room(int s, int e) {
            startTime = s;
            endTime = e;
        }

        @Override
        public int compareTo(room o){
            return o.startTime - this.startTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        room[] rooms = new room[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            rooms[i] = new room(s, e);
        }

        Arrays.sort(rooms, new Comparator<room>() {
            public int compare(room o1, room o2) {
                return o2.endTime - o1.endTime;
            }
        });

        for (int i = 0; i < n; i++) {
            room curRoom = rooms[i];

            if(pq.size() == 0) {
                //우선순위 큐가 비어있다면
                pq.add(curRoom);
                continue;
            }

            if(pq.peek().startTime < curRoom.endTime) {
                pq.add(curRoom);
            }
            // 힙 피크보다 작거나 같은 경우
            else{
                pq.poll();
                pq.add(curRoom);
            }
        }

        System.out.println(pq.size());

    }

}