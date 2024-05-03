import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;

    static int[] numContainer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        numContainer = new int[66];

        for (int i = 0; i < n; i++) {
            String cmd = br.readLine();
            char op = cmd.charAt(0);
            String num = cmd.substring(1);

            long number = Long.parseLong(num);


            int index = (int)(Math.log(number)  / Math.log(2));
            if(number == 0) {
                index = 65;
            }
            long maxValue = 0;

            if(op == '+') {
                numContainer[(int)index]++;
                for (int j = 0; j <= 62; j++) {

                    if(numContainer[j] > 1 && j != 62) {
                        numContainer[j] -= 2;
                        numContainer[j+1] += 1;
                    }

                    if(numContainer[j] > 0) {
                        maxValue = Math.max((long)Math.pow(2,j),maxValue);
                    }
                }
            } else if (index == 65) {
                for (int j = 0; j < 63 ; j++) {
                    if(numContainer[j] > 0) {
                        maxValue = Math.max((long)Math.pow(2,j),maxValue);
                    }
                }


            } else{
                for (int j = (int)index; j < 63; j++) {
                    if(numContainer[j] > 0) {
                        if(j != (int)index) {
                            numContainer[j] -= 1;
                            for(int k = j-1; k >= (int)index; k--) {
                                numContainer[k] = 1;
                            }
                        }
                        else{
                            numContainer[j]--;
                        }
                        break;
                    }
                }
                for (int j = 0; j < 63 ; j++) {
                    if(numContainer[j] > 0) {
                        maxValue = Math.max((long)Math.pow(2,j),maxValue);
                    }
                }
            }

            sb.append(maxValue +"\n");

        }
        System.out.println(sb.toString());
    }
}
