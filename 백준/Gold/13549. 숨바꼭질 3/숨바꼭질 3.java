import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visted = new boolean[100_001];
    static class Element {
        int time;
        int location;
        public Element(int t, int l) {
            time = t;
            location = l;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minTime = getMinFindTime(n, m);

        System.out.println(minTime);

    }

    public static int getMinFindTime(int start, int destination) {
        LinkedList<Element> q = new LinkedList<>();

        q.add(new Element(0, start));

        while(!q.isEmpty()) {
            //왼쪽,오른쪽,순간이동을 한번씩하면서 가장 빨리 찾는 경우를 찾는다.
            Element curElment = q.removeFirst();
            int curLocation = curElment.location;
            int curElapsedTime = curElment.time;
            visted[curLocation] = true;

            if(curLocation == destination) {
                return curElapsedTime;
            }

            if(canMove(curLocation + 1))
                q.add(new Element(curElapsedTime + 1, curLocation + 1));
            if(canMove(curLocation -1))
                q.add(new Element(curElapsedTime + 1, curLocation - 1));
            if(curLocation != 0 && inRange(curLocation * 2) )
                q.addFirst(new Element(curElapsedTime , curLocation * 2));

        }
        return 0;
    }
    public static boolean inRange(int location){
        if(location < 0 || location > 100_000)
            return false;
        return true;
    }

    public static boolean canMove(int location) {
        if(!inRange(location)) {
            return false;
        }

        if(visted[location]) return false;
        return true;
    }
}
