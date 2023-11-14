import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, entrance;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Road> best = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Road> worst = new PriorityQueue<>();

        for (int i=0; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                entrance = c;
                continue;
            }
            best.add(new Road(a, b, c));
            best.add(new Road(b, a, c));
            worst.add(new Road(a, b, c));
            worst.add(new Road(b, a, c));
        }

        int result = calculateFatigue(worst) - calculateFatigue(best);
        System.out.println(result);
    }
    private static int calculateFatigue(PriorityQueue<Road> pq) {
        root = new int[N+1];
        for (int i=1; i<=N; i++) {
            root[i] = i;
        }

        int up = 0;
        int connected = 0;

        while (!pq.isEmpty()) {
            if (connected == N - 1) break;
            Road cur = pq.poll();
            if (find(cur.s) == find(cur.e)) continue;
            union(cur.s, cur.e);
            connected++;
            if (cur.slope == 0) up++;
        }

        if (entrance == 0) up++;
        return up * up;
    }
    private static int find(int x) {
        if (x == root[x]) return x;
        else return root[x] = find(root[x]);
    }
    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) root[aRoot] = b;
    }
}
class Road implements Comparable<Road> {
    int s;
    int e;
    int slope;

    public Road(int s, int e, int slope) {
        this.s = s;
        this.e = e;
        this.slope = slope;
    }

    @Override
    public int compareTo(Road road) {
        return this.slope - road.slope;
    }
}