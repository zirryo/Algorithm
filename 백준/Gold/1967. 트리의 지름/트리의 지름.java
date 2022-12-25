import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node>[] tree;
    static boolean[] isVisited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[s].add(new Node(e, w));
            tree[e].add(new Node(s, w));
        }

        for(int i=1; i<=N; i++) {
            isVisited = new boolean[N+1];
            isVisited[i] = true;
            dfs(i, 0);
        }

        System.out.println(result);

    }
    static void dfs(int s, int diameter) {

        result = Math.max(result, diameter);

        for(int i=0; i<tree[s].size(); i++) {
            int next = tree[s].get(i).e;

            if(!isVisited[next]) {
                isVisited[next] = true;
                dfs(next, diameter + tree[s].get(i).w);
                isVisited[next] = false;
            }
        }

    }
    static class Node {
        int e;
        int w;

        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

}