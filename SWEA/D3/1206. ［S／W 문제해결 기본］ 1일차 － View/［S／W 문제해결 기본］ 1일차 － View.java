import java.io.*;
import java.util.*;

public class Solution{
    static int n;
    static int[] buildingHeights;

    public static void main(String[] args) throws IOException{

        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine().trim());
            int answer = 0;
            buildingHeights = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n ; i++) {
                buildingHeights[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < n - 2; i++) {
                int currentHeight = buildingHeights[i];
                int maxNeighborHeight = Math.max(Math.max(buildingHeights[i - 2], buildingHeights[i - 1]), Math.max(buildingHeights[i + 1], buildingHeights[i + 2]));
                if(currentHeight > maxNeighborHeight) {
                    answer += currentHeight - maxNeighborHeight;
                }
            }
            System.out.println("#" + t +" "+answer);
        }
    }
}