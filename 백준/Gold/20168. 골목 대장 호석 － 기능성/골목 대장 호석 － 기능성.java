import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int t, int w) { this.to = t; this.w = w; }
    }

    static final long INF = (long)1e18;

    static long dijkstra(List<Edge>[] g, int N, int A, int B, int cap) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        dist[A] = 0;
        pq.add(new long[]{0, A});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int)cur[1];
            if (d != dist[u]) continue;
            if (u == B) return d;
            for (Edge e : g[u]) {
                if (e.w > cap) continue;
                long nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new long[]{nd, e.to});
                }
            }
        }
        return dist[B];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        List<Edge>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        ArrayList<Integer> originalFeeList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
            originalFeeList.add(w);
        }


        Collections.sort(originalFeeList);
        ArrayList<Integer> uniqueFeeList = new ArrayList<>();
        int prev = -1;
        for (int f : originalFeeList) if (f != prev) { uniqueFeeList.add(f); prev = f; }

        int lo = 0, hi = uniqueFeeList.size() - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int cap = uniqueFeeList.get(mid);
            long shortest = dijkstra(g, N, A, B, cap);
            if (shortest <= C) {
                ans = cap;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
