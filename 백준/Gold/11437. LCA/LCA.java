import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int ROOT = 1;
    static int n,m;
    static ArrayList<Integer>[] graph;
    static int[][] pUnion;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        pUnion = new int[n+1][2];
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        findMychild(ROOT, ROOT, 1);

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findMinCommonAncestor(a,b) + "\n");
        }

        System.out.println(sb.toString());

    }

    public static void findMychild(int childNode, int parentNode,int depth) {
        visited[childNode] = true;
        pUnion[childNode][0] = parentNode;
        pUnion[childNode][1] = depth;

        for (int i = 0; i < graph[childNode].size(); i++) {
            int candidateNode = graph[childNode].get(i);

            if(!visited[candidateNode]) {
                findMychild(candidateNode, childNode,depth + 1);
            }
        }
    }

    public static int findMinCommonAncestor(int a, int b) {
        //a,b의 최소 공통 조상 찾기

        if(pUnion[a][1] > pUnion[b][1]) {
            int temp = a;
            a = b;
            b =  temp;
        }

        while(pUnion[a][1] < pUnion[b][1]) {
            if(pUnion[b][0] == a) return a;
            b = pUnion[b][0];
        }

        int aAncestor = a;
        int bAncestor = b;

        while(aAncestor != ROOT) {
            if(aAncestor == bAncestor) return aAncestor;
            aAncestor = pUnion[aAncestor][0];
            bAncestor = pUnion[bAncestor][0];
        }

        return ROOT;

    }


}