import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, vertexCnt, edgeCnt;
    static int caseNum = 1;
    static boolean[] visited;
    static ArrayList<Integer>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;
            visited = new boolean[N+1];
            edges = new ArrayList[N+1];

            for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                edges[s].add(e);
                edges[e].add(s);
            }
            int val = countTrees();
            sb.append("Case ").append(caseNum).append(": ");

            if(val == 0) sb.append("No trees.");
            else if(val == 1) sb.append("There is one tree.");
            else sb.append("A forest of ").append(val).append(" trees.");
            sb.append("\n");
            caseNum++;
        }
        System.out.println(sb);
    }
    private static int countTrees() {
        int trees = 0;
        for(int i=1; i<=N; i++) {
            if(visited[i]) continue; // 이미 연결된 정점일 경우 스킵
            vertexCnt = 0;
            edgeCnt = 0;
            dfs(i);

            // 트리는 정점이 n개, 간선이 n-1개 있으며, 임의의 두 정점에 대해서 경로가 유일해야 함.
            if(edgeCnt == 2*(vertexCnt-1)) trees++; // 양방향 간선이므로 * 2
        }
        return trees;
    }
    private static void dfs(int node) {
        visited[node] = true;
        vertexCnt++;
        edgeCnt += edges[node].size();

        for(int next : edges[node]) {
            if(visited[next]) continue;
            dfs(next);
        }
    }
}