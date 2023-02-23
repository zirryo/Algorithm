import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[] visited;
    static ArrayList<Integer>[] edges;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edges[s].add(e);
            edges[e].add(s);
        }
        for(int i=1; i<=N; i++) Collections.sort(edges[i]);
    }
    private static void dfs(int x) {
        visited[x] = true;
        sb.append(x).append(" ");

        for(Integer i : edges[x]) {
            if(visited[i]) continue;
            dfs(i);
        }
    }
    private static void bfs(int x) {
        visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(Integer i : edges[cur]) {
                if(visited[i]) continue;
                visited[i] = true;
                q.add(i);
            }
        }
    }
}