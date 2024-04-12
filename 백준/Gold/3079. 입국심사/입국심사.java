import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long m;
    public static long[] table;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());

        table = new long[(int)n];

        long max = 0;

        for(int i = 0; i < n; i++) {
            //심사대 입력 받기
            table[i] = Integer.parseInt(br.readLine());
            max = Math.max(table[i], max);

        }

        long left = 0;
        long right = max * m;
        long answer = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

//            sum = getPassCount(mid, (int)n);

            for (long l : table) {
                long cnt = mid/l;
                
                if(sum >= m) {
                    break;
                }
                sum += cnt;
            }
            

            if(sum >= m) {
                // 너무 많이 보냈다면
                answer = Math.min(mid, answer);
                right = mid - 1;

            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

//    public static long getPassCount(long time,int n) {
//        // time동안 몇명 Pass했는지 확인
//        long sum = 0;
//
//        for (int i = 0; i < n; i++) {
//            sum += time / table[i];
//        }
//
//        return sum;
//    }


}


