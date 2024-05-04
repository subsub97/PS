import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k,maxSize;
    static int[][][] stickers;
    static int[][] isStickerPlaced;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); //스티커 개수

        maxSize = 0;

        stickers = new int[k][][];
        isStickerPlaced = new int[n][m];

        for (int i = 0; i < k; i++) {
            //스티커 정보 받기
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            stickers[i] = new int[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < c; l++) {
                    stickers[i][j][l] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < k; i++) {
            simulate(i);
            if(maxSize != 0) {
                break;
            }
        }

        System.out.println(maxSize);

    }

    public static int[][] copySticker(int stickerNumber) {
        int[][] curSticker = new int[stickers[stickerNumber].length][stickers[stickerNumber][0].length];

        for (int i = 0; i < stickers[stickerNumber].length; i++) {
            for (int j = 0; j < stickers[stickerNumber][0].length; j++) {
                curSticker[i][j] = stickers[stickerNumber][i][j];
            }
        }

        return curSticker;
    }

    public static void simulate(int stickerNumber) {
        if(stickerNumber == k) return;

        int[][] curSticker = copySticker(stickerNumber);
        boolean flag = false;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    //스티커 붙일 수 있는 곳인지 확인
                    if (!canAttach(j, l, curSticker)) continue;
                    if(flag) return;

                    //스티커 부착 가능한 곳이라면 붙여
                    attach(j,l,curSticker);
                    flag = true;
                    //최대 사이즈 측정한다.
                    calculateSize();

                    //붙은 경우 다음 스티커를 붙인다
                    simulate(stickerNumber + 1);
                    //스티커를 뗀다.
                    remove(j,l,curSticker);
                }
            }

            if(flag){
                // 스티커가 붙는 경우 돌릴 필요 없다.
                return;
            }
            // 스티커를 돌려야한다.
                curSticker = turnClockwise(curSticker);
        }
        if(!flag)
            simulate(stickerNumber + 1);
    }
    public static void calculateSize() {
        int sum = 0;
        for (int i = 0; i < isStickerPlaced.length; i++) {
            for (int j = 0; j < isStickerPlaced[0].length; j++) {
                if(isStickerPlaced[i][j] == 1) {
                    sum++;
                }
            }
        }
        maxSize = Math.max(maxSize, sum);
    }
    public static void attach(int r, int c, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1)
                    isStickerPlaced[i+r][j+c] = 1;
            }
        }
    }

    public static void remove(int r, int c, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if(sticker[i][j] == 1)
                    isStickerPlaced[i+r][j+c] = 0;
            }
        }
    }

    public static boolean canAttach(int r, int c, int[][] sticker) {

        int stickerHeight = sticker.length;
        int stickerWidth = sticker[0].length;

        if(r + stickerHeight > n || c + stickerWidth > m) return  false;

        for (int i = 0; i < stickerHeight; i++) {
            for (int j = 0; j < stickerWidth; j++) {
                if(isStickerPlaced[r+i][c+j] == 1 && sticker[i][j] == 1) return false;
            }
        }

        return true;
    }

    public static int[][] turnClockwise(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int[][] newGrid = new int[c][r];
        
        //기존 격자 보고 그려야함
        for (int col = 0; col < r; col++) {
            for (int row = 0; row < c; row++) {
                if(grid[r -1 - col][row] == 1)
                    newGrid[row][col] = 1;
            }
        }
        return newGrid;
    }

}
