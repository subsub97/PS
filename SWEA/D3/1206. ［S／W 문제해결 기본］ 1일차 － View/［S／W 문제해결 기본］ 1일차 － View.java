

import java.io.*;
import java.util.*;

public class Solution{
    static int n;
    static int[][] buildingMap;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine().trim());
            int answer = 0;
            int[] buildingHeights = new int[n];
            buildingMap = new int[256][n];


            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n ; i++) {
                buildingHeights[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < buildingHeights[i]; j++) {
                    buildingMap[j][i] = 1;
                }
            }

            for (int i = 0; i < 256; i++) {
                for (int j = 0; j < n; j++) {
                    if(checkView(i,j)) {
                        answer++;
                    }
                }
            }
            System.out.println("#" + t +" "+answer);
        }
    }

    static boolean checkView(int row, int col) {
        if(buildingMap[row][col] == 0) {
            return false;
        }
        for (int i = 1; i <= 2; i++) {
            int checkPreCol = col - i;
            int checkAferCol = col + i;

            if(!inRange(row,checkAferCol)) return false;
            if(!inRange(row,checkPreCol)) return false;

            if(buildingMap[row][checkAferCol] == 1 || buildingMap[row][checkPreCol] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean inRange(int row,int col) {
        return row >= 0 && row < 256 && col >= 0 && col < n;
    }
}





