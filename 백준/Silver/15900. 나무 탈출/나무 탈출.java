import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt = 0;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        dfs(-1, 1, 0);
        if (cnt % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }
    private static void dfs(int prev, int node, int depth) {
        if (list[node].size() == 1 && prev != -1) {
            cnt += depth;
        } else {
            for (int next : list[node]) {
                if (next == prev) continue;
                dfs(node, next, depth + 1);
            }
        }
    }
}