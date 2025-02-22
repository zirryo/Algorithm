import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] parent, rank;
    static ArrayList<Edge> edges = new ArrayList<>();

    static class Planet {
        int x, y, z, index;

        Planet(int x, int y, int z, int index) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.index = index;
        }
    }

    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Planet[] planets = new Planet[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Planet(x, y, z, i);
        }

        // x, y, z 좌표에 대해 각각 정렬하고, 인접한 행성 간의 비용을 계산
        for (int d = 0; d < 3; d++) {
            final int dimension = d;
            Arrays.sort(planets, (a, b) -> {
                if (dimension == 0) return a.x - b.x;
                if (dimension == 1) return a.y - b.y;
                return a.z - b.z;
            });

            for (int i = 0; i < N - 1; i++) {
                int cost = Math.min(
                        dimension == 0 ? Math.abs(planets[i].x - planets[i + 1].x) :
                                dimension == 1 ? Math.abs(planets[i].y - planets[i + 1].y) :
                                        Math.abs(planets[i].z - planets[i + 1].z),
                        Integer.MAX_VALUE
                );
                edges.add(new Edge(planets[i].index, planets[i + 1].index, cost));
            }
        }

        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        Collections.sort(edges, (a, b) -> a.cost - b.cost);

        int mstCost = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                mstCost += edge.cost;
                edgeCount++;
                if (edgeCount == N - 1) {
                    break;
                }
            }
        }

        System.out.println(mstCost);
    }
}
