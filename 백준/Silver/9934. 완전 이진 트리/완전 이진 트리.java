import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        int buildings = (int) Math.pow(2, K) - 1;
        int[] list = new int[buildings];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<buildings; i++) list[i] = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, buildings-1));

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node n = q.poll();

                int parent = (n.left + n.right) / 2;
                sb.append(list[parent]).append(" ");

                if(n.left != n.right) {
                    q.add(new Node(n.left, parent-1));
                    q.add(new Node(parent+1, n.right));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}