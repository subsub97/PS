import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer>[] tree = new ArrayList[27];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 26; i++) {
            //트리 만들기
            tree[i] = new ArrayList<>();
        }

        //트리 연결하기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int rootNode = (int) (st.nextToken().charAt(0)) - 65;
            int childNode = 0;
            for (int j = 0; j < 2; j++) {
                String node = st.nextToken();
                if(node.equals(".")) {
                    childNode = -1;
                }else {
                    childNode = (int) node.charAt(0) - 65;
                }


                tree[rootNode].add(childNode);
            }
        }

        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb.toString());



    }

    public static void preorder(int node) {
        //전위 순회 루-> 왼쪽 -> 오른쪽
        sb.append((char)(node + 65));

        for (int i = 0; i < tree[node].size(); i++) {
            if(tree[node].get(i) == -1) continue;
            preorder(tree[node].get(i));
        }
    }

    public static void inorder(int node) {
        boolean flag = true;

        for (int i = 0; i < tree[node].size(); i++) {
            flag = false;
            if(tree[node].get(i) != -1)
                inorder(tree[node].get(i));
            if(i==0)
                sb.append((char)(node + 65));
        }

        if(flag) {
            sb.append((char)(node + 65));
        }
    }

    public static void postorder(int node) {
        for (int i = 0; i < 2; i++) {
            if(tree[node].get(i) == -1) continue;
            postorder(tree[node].get(i));
        }
        sb.append((char)(node + 65));
    }
}
