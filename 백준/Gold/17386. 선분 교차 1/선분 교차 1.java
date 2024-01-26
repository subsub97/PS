import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int OFFSET = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] line = new long[2][4];


        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                line[i][j] = Long.parseLong(st.nextToken()) + OFFSET;
            }
        }

        Vector1 ab = new Vector1(line[0][0],line[0][1],line[0][2],line[0][3]); // ab 벡터
        Vector1 cd = new Vector1(line[1][0],line[1][1],line[1][2],line[1][3]); // cd 벡터
        Vector1 ac = new Vector1(line[0][0],line[0][1],line[1][0],line[1][1]);
        Vector1 ad = new Vector1(line[0][0],line[0][1],line[1][2],line[1][3]);
        Vector1 ca = new Vector1(line[1][0],line[1][1],line[0][0],line[0][1]);
        Vector1 cb = new Vector1(line[1][0],line[1][1],line[0][2],line[0][3]);

        int ccw1 = ccw(ab,ac);
        int ccw2 = ccw(ab,ad);
        int ccw3 = ccw(cd,ca);
        int ccw4 = ccw(cd,cb);

        int multCCW12 = ccw1 * ccw2;
        int multCCW34 = ccw3 * ccw4;

        boolean overlap = false;

        if(multCCW12 <= 0 && multCCW34 <=0) {
            if(multCCW12 == 0 || multCCW34 == 0) {
                if(Math.min(line[0][0],line[0][2]) >= Math.max(line[1][0],line[1][2]) || Math.max(line[0][0],line[0][2]) <= Math.min(line[1][0],line[1][2])) {
                    // x축 안겹치는 경우
                    System.out.println(0);
                    return;
                }
                if(Math.min(line[0][1],line[0][3]) >= Math.max(line[1][1],line[1][3]) || Math.max(line[0][1],line[0][3]) <= Math.min(line[1][1],line[1][3])) {
                    // y축 안겹치는 경우
                    System.out.println(0);
                    return;
                }
            }
            overlap = true;
        }

        if(overlap) {
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }

    public static class Vector1 {
        long x;
        long y;
        Vector1(long x1,long y1, long x2, long y2) {
            // x2 종점 y2종점 x1,y1 시점
            this.x = x2 - x1;
            this.y = y2 - y1;
        }
    }

    public static int ccw(Vector1 v1,Vector1 v2) {
        long result = v1.x * v2.y - v1.y * v2.x;
        if(result > 0) {
            return 1;
        }
        else if (result == 0) {
            return 0;
        }
        else{
            return -1;
        }
    }
}
