import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nodes = new Node[N+1];

        StringTokenizer st;
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isSheep = st.nextToken().charAt(0) == 'S';
            long count = Long.parseLong(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            if (nodes[i] == null) {
                nodes[i] = new Node(isSheep, count);
            } else {
                nodes[i].isSheep = isSheep;
                nodes[i].cnt = count;
            }

            if (nodes[parent] == null) {
                nodes[parent] = new Node(isSheep, 0);
            }
            nodes[parent].child.add(i);
        }

        System.out.println(dfs(1));
    }

    static long dfs(int idx) {
        Node cur = nodes[idx];
        long sheep = 0L;

        for (int children : cur.child) {
            sheep += dfs(children);
        }

        if (cur.isSheep) {
            sheep += cur.cnt;
        } else {
            sheep = Math.max(0, sheep - cur.cnt);
        }

        return sheep;
    }

    static class Node {
        boolean isSheep;
        long cnt;
        List<Integer> child;

        Node(boolean isSheep, long cnt) {
            this.isSheep = isSheep;
            this.cnt = cnt;
            child = new ArrayList<>();
        }
    }
}