import java.util.*;
import java.io.*;

public class Main {
    static int MAX_LENGHT = 200000;
    static int[][] arr2d = new int[27][MAX_LENGHT+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char cur_c;

        for(int i = 0; i < str.length(); i++) {
            if(i == 0){
                cur_c = str.charAt(i); //현재 무슨 문자가 선택되었는지 확인
                arr2d[(int) cur_c - 97][i] = arr2d[(int) cur_c - 97][i] + 1;
            }
            else{
                for (int j = 0; j < 27; j++) {
                    arr2d[j][i] = arr2d[j][i-1];
                }
                cur_c = str.charAt(i); //현재 무슨 문자가 선택되었는지 확인
                arr2d[(int) cur_c - 97][i] = arr2d[(int) cur_c - 97][i - 1] + 1;
            }

        }

        int n = Integer.parseInt(br.readLine());
        String a;
        int c,b;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int row = ((int)a.charAt(0)) -97;
            if(b==0)System.out.println(arr2d[row][c]);
            else System.out.println(arr2d[row][c] - arr2d[row][b-1]);
        }
    }
}
