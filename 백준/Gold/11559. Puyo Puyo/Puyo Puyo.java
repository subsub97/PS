import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_ROW = 12;
    static final int MAX_COL = 6;
    static int answer = -1;

    static char[][] grid =new char[MAX_ROW][MAX_COL];
    static boolean[][] visited = new boolean[MAX_ROW][MAX_COL];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < MAX_ROW; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            for (int j = 0; j < MAX_COL; j++) {
                grid[i][j] = cmd.charAt(j);
            }
        }

        simulate();

        System.out.print(answer);

    }

    public static void simulate() {
        //터질수 있는지 확인
        ArrayList<Node> nodes = new ArrayList<>();


        while(true){
            answer++;
            boolean flag = true;
            visited = new boolean[MAX_ROW][MAX_COL];

            for (int i = 0; i < MAX_ROW; i++) {
                for (int j = 0; j < MAX_COL; j++) {
                    if(grid[i][j] == '.') continue;
                    if(visited[i][j]) continue;
                    nodes = bfs(new Node(i, j, grid[i][j]));

                    if(nodes.size() > 3) {
                        // 터트리기....
                        doExplode(nodes);
                        flag = false;
                    }
                }
            }
            // 터진 경우 가 없다면 false;
            if(flag) break;
            drop();

        }



    }

    public static ArrayList<Node> bfs(Node node) {
        Queue<Node> q = new LinkedList<Node>();

        ArrayList<Node> checked = new ArrayList<Node>();
        visited[node.row][node.col] = true;
        checked.add(node);
        q.add(node);

        int[] drs = {1, -1, 0, 0};
        int[] dcs = {0, 0, 1, -1};

        while(q.size() > 0) {
            Node curr = q.poll();

            for(int i = 0; i < 4; i++) {
                int nextRow = curr.row + drs[i];
                int nextCol = curr.col + dcs[i];

                if(!canMove(nextRow,nextCol,curr.info)) continue;
                visited[nextRow][nextCol] = true;
                Node newNode = new Node(nextRow,nextCol,curr.info);
                q.add(newNode);
                checked.add(newNode);
            }
        }
        return checked;
    }

    public static void doExplode(ArrayList<Node> bombs) {
        for (int i = 0; i < bombs.size(); i++) {
            Node node = bombs.get(i);
            grid[node.row][node.col] = '.';
        }
    }

    public static void drop() {
        //뿌요 뿌요 공백 떨구기
        for (int i = 0; i < MAX_COL; i++) {
            // 아래부터 공백있으면 당기기
            char[] temp = new char[MAX_ROW];
            Arrays.fill(temp,'.');
            int idx = MAX_ROW - 1;

            for (int j = MAX_ROW -1; j > -1 ; j--) {
                if(grid[j][i] != '.') {
                    //현재 grid에 공백이 아닌 경우
                    temp[idx--] = grid[j][i];
                }
            }
            // temp에 옮겨둔 정보다 다시 grid로 옮기기
            for (int j = 0; j < MAX_ROW; j++) {
                grid[j][i] = temp[j];
            }
        }

    }

    /// 모두 터트리고 떨구고 -> 카운트 업하고

    static class Node {
        int row;
        int col;
        char info;

        Node(int row, int col, char info) {
            this.row = row;
            this.col = col;
            this.info = info;
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < MAX_ROW && c >= 0 && c < MAX_COL;
    }

    public static boolean canMove(int r, int c,char alpa) {
        if(!inRange(r, c)) return false;
        if(visited[r][c]) return false;
        if(grid[r][c] != alpa) return false;
        return true;
    }
}
