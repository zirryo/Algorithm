import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node root = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            char x = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(root, x, left, right);
        }

        pre(root);
        sb.append("\n");
        in(root);
        sb.append("\n");
        post(root);
        System.out.println(sb);
    }

    public static void insert(Node n, char x, char left, char right) {

        if(n.val == x) {
            if(left == '.') {
                n.left = null;
            } else {
                n.left = new Node(left, null, null);
            }

            if(right == '.') {
                n.right = null;
            } else {
                n.right = new Node(right, null, null);
            }
        } else {
            if(n.left != null) insert(n.left, x, left, right);
            if(n.right != null) insert(n.right, x, left, right);
        }
    }

    public static void pre(Node node) {
        if(node == null) return;

        sb.append(node.val);
        pre(node.left);
        pre(node.right);
    }

    public static void in(Node node) {
        if(node == null) return;

        in(node.left);
        sb.append(node.val);
        in(node.right);
    }

    public static void post(Node node) {
        if(node == null) return;

        post(node.left);
        post(node.right);
        sb.append(node.val);
    }

    public static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}