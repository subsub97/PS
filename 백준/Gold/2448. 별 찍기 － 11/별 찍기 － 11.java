import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        grid = new char[n][n * 2 - 1];

        for(int i = 0; i < n; i++) {
            Arrays.fill(grid[i], ' ');
        }

        draw(0,n-1,n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2-1; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());


    }

    public static void draw(int r, int c, int n) {
        if(n == 3) {
            grid[r][c] = '*';

            grid[r + 1][c - 1] = '*'; grid[r + 1][c + 1] = '*';

            grid[r + 2][c + 2] = '*'; grid[r + 2][c + 1] = '*'; grid[r + 2][c] = '*'; grid[r + 2][c - 1] = '*'; grid[r + 2][c - 2] = '*';
            return;
        } else {
            int cut = n / 2;
            draw(r, c, cut);
            draw(r + cut, c - cut, cut);
            draw(r + cut, c + cut, cut);
        }
    }
}
