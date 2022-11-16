import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];

        for(int i=1; i<=V; i++) {
            parent[i] = i;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Edge(s, e, w));
        }

        while(E-->0) {
            Edge edge = pq.poll();

            int a = find(edge.start);
            int b = find(edge.end);

            if(a == b) continue; // 부모가 같으면 사이클 발생 -> 유니온 X
            union(a, b);
            result += edge.weight;
        }

        System.out.println(result);
    }


// 크루스칼 알고리즘의 기본 메서드 find, union
    public static int find(int x) {
        if(x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) parent[aRoot] = b;
        else return;
    }

    public static class Edge implements Comparable<Edge> {

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        // weight 를 기준으로 오름차순 정렬
        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

}