import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++){
            parent[i] = i;
        }

        int cycle = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (find(u) == find(v)) {
                cycle++;
                continue;
            }

            union(u, v);
        }

        int group = 0;
        for (int i = 1; i <= N; i++){
            if (parent[i] == i) group++;
        }

        System.out.println(group + cycle - 1);
    }
    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u > v) parent[v] = u;
        else parent[u] = v;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}