import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[] dpArr = new int[x + 1];
        if (x >= 4) {
            dpArr[0] = 0; // x가 1인 경우
            dpArr[1] = 1; // x가 2인 경우
            dpArr[2] = 1; // x가 3인 경우
            dpArr[3] = 1;
        } else { // x가 4보다 작은 값인 경우 인덱스 오류를 방지하기 위함
            dpArr = new int[]{0, 0, 1, 1};
        }

        for (int i = 4; i <= x; i++) {
            dpArr[i] = dpArr[i - 1] + 1; // -1을 했을 때 가능한 경우

            if (i % 3 == 0) {
                dpArr[i] = Math.min(dpArr[i], dpArr[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dpArr[i] = Math.min(dpArr[i], dpArr[i / 2] + 1);
            }
        }

        System.out.println(dpArr[x]);
    }
}
