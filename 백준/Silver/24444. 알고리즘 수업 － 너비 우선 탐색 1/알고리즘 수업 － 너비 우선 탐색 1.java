import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, start;
    static ArrayList<Integer>[] list;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(sb);
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
        start = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }
        for(int i=1; i<=N; i++) Collections.sort(list[i]);
    }
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int order = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(visited[cur] != 0) continue;
            visited[cur] = order;
            order++;
            for(int next : list[cur]) {
                if(visited[next] == 0) {
                    q.add(next);
                }
            }
        }

        for(int i=1; i<=N; i++) sb.append(visited[i]).append("\n");
    }
}