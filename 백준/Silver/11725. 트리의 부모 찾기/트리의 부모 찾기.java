import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[N+1];
        int[] parent = new int[N+1];

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        for(int i=0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            tree.get(p1).add(p2);
            tree.get(p2).add(p1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        isVisited[1] = true;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int n : tree.get(node)) {
                if(!isVisited[n]) {
                    isVisited[n] = true;
                    q.add(n);
                    parent[n] = node;
                }
            }
        }

        for(int i=2; i<=N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}