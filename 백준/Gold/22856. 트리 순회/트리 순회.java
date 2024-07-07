import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int left;
        int right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Integer, Node> tree = new HashMap<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.put(parent, new Node(left, right));
        }

        findOneWay(1);
        int result = (n - 1) * 2 - cnt;
        System.out.println(result);
    }

    static void findOneWay(int node) {
        int right = tree.get(node).right;
        if (right == -1) return;
        cnt++;
        findOneWay(right);
    }

}