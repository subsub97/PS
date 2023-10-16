import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static String[] lineArr;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while ((str = br.readLine())!= null){
            n = Integer.parseInt(str);
            int k = (int)Math.pow(3,n);

//            lineArr = new String[k];
            answer = new StringBuilder();

            for (int j = 0; j < k; j++) {
//            lineArr[j] = "-";
                answer.append("-");
            }
            spliter(n);

        }

    }

    public static void spliter(int depth) {
        if(depth == 0) {
            printLine();
            return;
        }

        int repeat = (int)Math.pow(3,n-depth);
        int len = (int)Math.pow(3,depth);
        int zeroLen = len/3;

        for (int i = 0; i < repeat; i++) {
            for (int j = 0; j < len; j++) {
//                if(lineArr[j+(i*len)].equals(" ") || (zeroLen <= j && j <zeroLen*2)){
//                    lineArr[j+(i*len)] =" ";
//                }
                if(answer.charAt(j+(i*len)) == ' ' || (zeroLen <= j && j <zeroLen*2)) {
                    answer.setCharAt(j+(i*len),' ');
                }
            }
        }

        spliter(depth-1);
    }

    public static void printLine() {
//        for (int i = 0; i < (int)Math.pow(3,n); i++) {
//            System.out.print(lineArr[i]);
//        }
//        System.out.println();
//    }
        System.out.println(answer);
    }
}





