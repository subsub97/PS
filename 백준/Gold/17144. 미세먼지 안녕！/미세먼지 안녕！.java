import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int rightR, reverseR;
    static int[][] grid,addGrid,minusGrid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        grid = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getCleanerPos(); // 공기청정기 위치 찾기

        simulate();
        int answer = getDustAmount();

        System.out.println(answer);

    }

    public static void getCleanerPos() {
        for (int i = 0; i < R; i++) {
            if(grid[i][0] == -1){
                rightR = i+1;
                reverseR = i;
                break;
            }
        }
    }

    public static int getDustAmount() {
        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(grid[i][j] > 0){
                    sum += grid[i][j];
                }
            }
        }
        return sum;
    }

    public static void simulate() {
        while (T-- > 0) {
            addGrid = new int[R][C];
            minusGrid = new int[R][C];
            //확산하기
            diffuse();

            // 시계방향 돌리기
            reverseClockWise(reverseR,0);
            clockWise(rightR,0);
        }
    }

    public static void diffuse() {
        int[] drs = {-1, 0, 1, 0};
        int[] dcs = {0, -1, 0, 1};


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int cnt = 0;

                if(grid[i][j] > 4) {
                    for (int k = 0; k < 4; k++) {
                        int nextR = i + drs[k];
                        int nextC = j + dcs[k];
                        if (inRange(nextR, nextC)) {
                            if((nextR == reverseR && nextC ==0) || (rightR == nextR && nextC == 0)){
                                continue;
                            }
                            //확산 가능한 경우
                            cnt++;
                            addGrid[nextR][nextC] = addGrid[nextR][nextC] + grid[i][j] / 5;
                        }
                    }
                    minusGrid[i][j] = ((grid[i][j] / 5) * cnt);
                }

            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] += addGrid[i][j];
                grid[i][j] -= minusGrid[i][j];
            }
        }

    }

    public static boolean inRange(int r, int c) {
        return (r >= 0 && r < R) && (c >= 0 && c < C);
    }

    public static void clockWise(int r, int c) {
        // 여기서 r은 공기청정기 하단 부분
        //시계방향 돌리기
        for (int i = r + 1; i < R-1; i++) {
            grid[i][0] = grid[i+1][0];
        }

        for(int i = 0; i < C-1; i++) {
            grid[R-1][i] = grid[R-1][i+1];
        }

        for (int i = R-1; i > r; i--) {
            grid[i][C-1] = grid[i-1][C-1];
        }

        for (int i = C-1; i > 1 ; i--) {
            grid[r][i] = grid[r][i-1];
        }
        grid[r][c+1] = 0;
    }

    public static void reverseClockWise(int r, int c) {
        // 0번째 열에서 부터
        for (int i = r-1; i > 0; i--) {
            grid[i][0] = grid[i-1][0];
        }

        for(int i = 0; i < C-1; i++) {
            grid[0][i] = grid[0][i+1];
        }

        for (int i = 0; i < r; i++) {
            grid[i][C-1]= grid[i + 1][C-1];
        }

        for (int i = C-1; i > 1; i--) {
            grid[r][i] = grid[r][i-1];
        }
        grid[r][c+1] = 0;
    }

}
