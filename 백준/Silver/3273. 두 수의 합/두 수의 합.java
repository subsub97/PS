import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start=0,end=n-1;
        int result = 0;
        int cur_sum;
        while(start < end){
            cur_sum = arr[start] + arr[end];
            if(cur_sum == x){
                result++;
                end--;
            }
            else{
                // 현재 합이 x값보다 큰경우
                if(cur_sum > x){
                    end--;
                }
                //cur_sum이 x보다 작은경우
                else start++;
            }
        }
        System.out.println(result);
    }
}
