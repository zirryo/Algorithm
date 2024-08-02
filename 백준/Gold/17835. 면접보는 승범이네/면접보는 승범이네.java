import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        ArrayList<Road>[] roads = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            roads[v].add(new Road(u, c));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] distToDestination = new long[N+1];
        Arrays.fill(distToDestination, 100000L * 100000);

        PriorityQueue<Road> pq = new PriorityQueue<>(Comparator.comparing(road -> road.dist));
        for (int x : arr) {
            distToDestination[x] = 0;
            pq.add(new Road(x, 0));
        }

        while (!pq.isEmpty()) {
            Road cur = pq.poll();

            if (cur.dist > distToDestination[cur.end]) continue;

            for (Road next : roads[cur.end]) {
                int nextEnd = next.end;
                long nextDist = cur.dist + next.dist;

                if (nextDist < distToDestination[nextEnd]) {
                    distToDestination[nextEnd] = nextDist;
                    pq.add(new Road(nextEnd, nextDist));
                }
            }
        }

        long maxDist = -1;
        int cityNum = -1;

        for (int i = 1; i <= N; i++) {
            if (distToDestination[i] != 100000L * 100000 && distToDestination[i] > maxDist) {
                maxDist = distToDestination[i];
                cityNum = i;
            }
        }

        System.out.println(cityNum + "\n" + maxDist);
    }
}
class Road {
    int end;
    long dist;

    public Road(int end, long dist) {
        this.end = end;
        this.dist = dist;
    }
}