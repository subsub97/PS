import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[2];
        Arrays.sort(arr);
        int min_val = Math.abs(arr[0] + arr[n-1]);
        result[0] = arr[0]; result[1] =arr[n-1];

        int start = 0, end = n-1; //포인터 시작과 끝점 생성

        while(start<end){
            if(min_val > Math.abs(arr[start] + arr[end])){
                min_val = Math.abs(arr[start] + arr[end]);
                result[0] = arr[start];
                result[1] = arr[end];
            }
            if (arr[start] + arr[end] > 0) end--;
            else start++;


        }
        System.out.println(result[0] + " " + result[1]);

    }

}

