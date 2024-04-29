import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] times;
    static int n,k,c;
    static long minTime;
    static HashMap<String, Integer> visited = new HashMap<String, Integer>();

    static int maxValue;

    static int timeSum;

    public static void main(String[] args) throws Exception {

        n = read();
        k = read();
        c = read();
        maxValue = 0;
        times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = read();
            timeSum += times[i];
            maxValue = Math.max(times[i],maxValue);
        }

        minTime = Long.MAX_VALUE;

        getMinTime(0);
        System.out.println(minTime);

    }

    private static int read() throws Exception {
        int d, o = System.in.read() & 15;
        while ((d = System.in.read()) > 32)
            o = (o << 3) + (o << 1) + (d & 15);
        return o;
    }

    static void getMinTime(int level) {

        for (int i = level; i < n; i++) {
            if(c > 0 && times[i] > 1) {
                c--;
                timeSum--;
                times[i]--;
                getMinTime(i);
                timeSum++;
                times[i]++;
                c++;
            }

            if(c == 0 || timeSum >= n)  {
                checkCurrentTime();
            }

        }
    }

    static void checkCurrentTime() {
        long start = 0L;
        long end = maxValue * 1_000_0000L;

        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += mid / times[i];
            }

            if(sum >= k) {
                minTime = Math.min(minTime, mid);
                end = mid - 1;
                continue;
            }

            start = mid + 1;


        }
    }

}

