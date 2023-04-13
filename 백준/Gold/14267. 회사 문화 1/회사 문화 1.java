import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] comp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N+1];
        comp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if(i == 1) continue;
            tree[boss].add(i);
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            comp[a] += b;
        }

        dfs(1);
        for(int i=1; i<=N; i++) sb.append(comp[i]).append(" ");
        System.out.println(sb);
    }
    private static void dfs(int x) {
        for(int sub : tree[x]) {
            comp[sub] += comp[x];
            dfs(sub);
        }
    }
}