import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int idx = 0;
    static Node root = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while(true) {
             input = br.readLine();
            if(input == null || input.equals("")) {
                break;
            }
            list.add(Integer.parseInt(input));
        }

        root = new Node(list.get(idx++));

        while(idx < list.size()) {
            root.insert(list.get(idx++));
        }

        makeTree(root,1);
        postOrder(root);

    }

    public static Node makeTree(Node node,int dir) {
        Node newNode = null;
        return newNode;
    }

    static class Node {
        Node left = null, right = null;
        int value;

        Node(int v) {
            value = v;
        }

        public void insert(int v) {
            if(v <= value) {
                // 왼쪽 자식인 경우
                if(left == null) {
                    left = new Node(v);
                }
                else{
                    left.insert(v);
                }
            }
            else{
                if(right == null) {
                    right = new Node(v);
                }
                else {
                    right.insert(v);
                }
            }
        }
    }

    public static void postOrder(Node node) {
        if(node.left != null) {
            postOrder(node.left);
        }
        if(node.right != null) {
            postOrder(node.right);
        }

        System.out.println(node.value);
    }
}