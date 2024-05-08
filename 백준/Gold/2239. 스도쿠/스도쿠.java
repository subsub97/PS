import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 81;
    static boolean flag = false;
    static int[][] grid = new int[10][10];
    static boolean[][] rowVisited = new boolean[10][10];
    static boolean[][] colvisited = new boolean[10][10];

    static boolean[][] square = new boolean[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            String st = br.readLine();
            for (int j = 1; j <= 9; j++) {
                grid[i][j] = Integer.parseInt(st.substring(j-1,j));

                if(grid[i][j] != 0) {
                    count--;
                    int idx = getThreeArea(i,j);
                    square[idx][grid[i][j]] = true;
                    rowVisited[i][grid[i][j]] = true;
                    colvisited[j][grid[i][j]] = true;
                    }
                }
            }

        dfs(1,1);
        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void dfs(int i, int j) {
        if(count == 0 || flag) {
            flag = true;
            return;
        }
        if(j > 9) {
            j = 1;
            i+=1 ;
        }
            for (int k = 1; k <= 9; k++) {

                //k는 현저 스도쿠에 넣을 수
                int idx = getThreeArea(i,j);

                if(grid[i][j] != 0)  {
                    dfs(i,j+1);
                    return;}
                if(square[idx][k]) continue;
                if(rowVisited[i][k]) continue;
                if(colvisited[j][k]) continue;

                rowVisited[i][k] = true;
                colvisited[j][k] = true;
                square[idx][k] = true;
                grid[i][j] = k;
                count--;

                dfs(i,j + 1);
                if(flag){
                    return;
                }

                grid[i][j] = 0;
                count++;
                rowVisited[i][k] = false;
                colvisited[j][k] = false;
                square[idx][k] = false;
            }

    }
    public static int getThreeArea(int r, int c) {
        int idx = 0;
        r -= 1;
        c -= 1;

        if(r < 3 && c < 3) {
            idx = 0;
        } else if ( r < 3 && c < 6) {
            idx =1 ;
        } else if (r < 3 && c < 9) {
            idx = 2;
        } else if (r < 6 && c < 3) {
            idx =3 ;
        } else if (r < 6 && c < 6) {
            idx = 4;
        } else if (r < 6 && c <9) {
            idx = 5;
        } else if (r < 9 && c < 3) {
            idx = 6;
        } else if (r < 9 && c <6) {
            idx = 7;
        }else{
            idx = 8;
        }
        return idx;
    }
}
