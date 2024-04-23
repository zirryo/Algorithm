import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] subTrees;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int R = Integer.parseInt(st.nextToken()); // 루트 번호
        int Q = Integer.parseInt(st.nextToken()); // 쿼리의 수

        list = new ArrayList[N+1];
        subTrees = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        dfs(R);
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int x = Integer.parseInt(br.readLine());
            sb.append(subTrees[x] + "\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int cur) {
        if (subTrees[cur] != 0) return subTrees[cur];

        visited[cur] = true;
        int cnt = 1;

        for (int next : list[cur]) {
            if (visited[next]) continue;
            cnt += dfs(next);
        }

        return subTrees[cur] = cnt;
    }
}