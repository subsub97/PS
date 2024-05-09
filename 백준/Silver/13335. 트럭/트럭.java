import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.prefs.PreferenceChangeListener;

public class Main {

    static int n , l, w,curMaxWeight,elaspedTime,remainder;
    static int removeIdx;
    static int[] tracks;
    static int[] bridge;
    static Queue<Integer> q = new LinkedList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        remainder = n;
        curMaxWeight = w;
        elaspedTime = 0;
        removeIdx = 0;

        tracks = new int[n];
        bridge = new int[l];



        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            tracks[i] = Integer.parseInt(st.nextToken());
        }

        simulate();


    }

    public static void simulate() {
        int tIdx = 0;

        while(remainder > 0) {
            move();

            if(canAppoach(tIdx) && !flag) {

                //트럭이 다리위로 올라가는 경우
                curMaxWeight -= tracks[tIdx++];
                q.add(0);

                if(tIdx == n) {
                    tIdx = n-1;
                    flag = true;
                }
            }

            if(remainder == 0){
                System.out.println(elaspedTime + 1);
                break;
            }

            elaspedTime++;
        }
    }

    public static boolean canAppoach(int idx) {
        return curMaxWeight - tracks[idx] >= 0;
    }

    public static void move() {
        for (int i = 0; i < q.size(); i++) {
            int idx = q.poll();

            idx++;

            if(idx == l) {
                remainder--;
                curMaxWeight += tracks[removeIdx++];
                q.add(idx);
                continue;
            }

            q.add(idx);

        }
    }
}
