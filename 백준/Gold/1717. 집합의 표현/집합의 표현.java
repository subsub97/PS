import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] uf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        uf = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken()) ;
            int c = Integer.parseInt(st.nextToken()) ;

            if(cmd == 0) {
                //합집합
                union(p,c);
            }

            else{
                if (find(p) == find(c)) {
                    System.out.println("YES");
                    continue;
                }
                System.out.println("NO");
            }
        }
    }

    static int find(int x) {
        if(uf[x] == x)
            return x;
        uf[x] = find(uf[x]);
        return uf[x];
    }

    static void union(int parent, int child) {
        
        uf[find(parent)] = find(child);
    }
}

