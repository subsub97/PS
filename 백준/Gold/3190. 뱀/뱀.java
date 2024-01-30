import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] appleRow = new int[k];
        int[] appleCol = new int[k];

        map = new int[n][n];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            appleRow[i] = Integer.parseInt(st.nextToken());
            appleCol[i] = Integer.parseInt(st.nextToken());
            map[appleRow[i] - 1][appleCol[i] -1] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        int[] time = new int[l];
        char[] direction = new char[l];

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //방향 정보 입력받기
            time[i] = Integer.parseInt(st.nextToken());
            direction[i] = st.nextToken().charAt(0);
        }

        boolean playButton = true;
        int elapseTime = 0;
        int lIdx = 0;
        int kIdx = 0;

        // 우,하,좌,상 방향
        int[] drs = {0,1,0,-1};
        int[] dcs = {1,0,-1,0};
        int dirIdx = 0;
        int row = 0;
        int col = 0;
        map[0][0] = 2;

        Queue<Location> snailInfo = new LinkedList<>();

        while(playButton) {
            // 게임실행
            elapseTime++;
            snailInfo.add(new Location(row, col));

            row += drs[dirIdx];
            col += dcs[dirIdx];

            if(!canGo(row,col)) {
                System.out.println(elapseTime);
                break;
            }
            // 2는 뱀의 위치를 의미한다.


            if(map[row][col] == 0) {
                // 사과가 없는 경우
                Location location = snailInfo.poll();
                map[location.row][location.col] = 0;
            }

            if(elapseTime == time[lIdx]) {
                //방향 전환하는 시간이 발생한 경우
                if(direction[lIdx] == 'L') {
                    //좌측으로 방향 전환인 경우
                    dirIdx--;
                    if(dirIdx < 0) dirIdx = 3;
                }
                else{
                    //우측으로 방향 전환인 경우
                    dirIdx = (dirIdx + 1) % 4;
                }
                if(lIdx < l-1)lIdx++;
            }
            map[row][col] = 2;
        }
    }

    public static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static boolean canGo(int row, int col) {
        if(!inRange(row,col)) {
            return false;
        }
        if(map[row][col] == 2) {
            // 자신의 몸통이 있는 경우
            return false;
        }
        return true;
    }

    public static class Location {
        int row;
        int col;

        Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}
