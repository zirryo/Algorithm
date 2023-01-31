import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, R, W;
    static int INF = 10000 * 2700;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(TC -- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N+1];
            edges = new ArrayList[N+1];

            for(int i=1; i<=N; i++) edges[i] = new ArrayList<>();

            for(int i=0; i<R+W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if(i < R) {
                    edges[S].add(new Edge(E, T));
                    edges[E].add(new Edge(S, T));
                }
                else edges[S].add(new Edge(E, -T));
            }

            boolean result = bellmanFord();

            if(result) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }

    private static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0; // 시작 노드 == 1
        boolean update = false;

        for(int i=1; i<N; i++) { // 시작점을 제외한 노드의 수 == N-1
            update = false;
            for(int j=1; j<=N; j++) {
                for(Edge next : edges[j]) { // 현재 노드의 모든 인접 노드 탐색
                    if(dist[next.e] > dist[j] + next.w) {
                        dist[next.e] = dist[j] + next.w; // 경유하는 것이 더 가까울 경우 갱신
                        update = true;
                    }
                }
            }
            if(!update) break;
        }

        if(update) {
            for(int i=1; i<=N; i++) {
                for(Edge next : edges[i]) {
                    if(dist[next.e] > dist[i] + next.w) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Edge {
        int e; // 도착지
        int w; // 가중치

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}