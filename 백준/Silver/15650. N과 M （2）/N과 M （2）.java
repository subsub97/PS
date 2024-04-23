import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> number = new ArrayList<>();
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        selected = new boolean[n + 1];

        choose(0, n, m);
    }

    public static void choose(int depth, int n, int m) {
        if(depth == m) {
            printNumber();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!selected[i]) {
                if(number.size() == 0 || i > number.get(number.size() -1)){
                    selected[i] = true;
                    number.add(i);
                    choose(depth + 1, n, m);
                    number.remove(number.size() - 1);
                    selected[i] = false;
                }
            }
        }
        return;
    }

    public static void printNumber() {
        for (int i = 0; i < number.size(); i++) {
            System.out.print(number.get(i) + " ");
        }
        System.out.println();
    }
}
