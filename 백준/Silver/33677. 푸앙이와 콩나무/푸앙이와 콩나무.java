import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    static class State {
        int x, days, water;
        State(int x, int days, int water) {
            this.x = x;
            this.days = days;
            this.water = water;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N + 1];
        int[] water = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(water, INF);

        Queue<State> q = new ArrayDeque<>();
        dist[0] = 0;
        water[0] = 0;
        q.add(new State(0, 0, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.days > dist[cur.x]) continue;
            if (cur.days == dist[cur.x] && cur.water > water[cur.x]) continue;

            int nx = cur.x + 1;
            if (nx <= N) {
                addToQueue(q, dist, water, cur, nx, 1);
            }

            nx = cur.x * 3;
            if (nx <= N) {
                addToQueue(q, dist, water, cur, nx, 3);
            }

            long sq = (long) cur.x * cur.x;
            if (sq <= N) {
                addToQueue(q, dist, water, cur, (int) sq, 5);
            }
        }

        System.out.println(dist[N] + " " + water[N]);
    }

    static void addToQueue(Queue<State> q, int[] dist, int[] water,
                           State cur, int nx, int addWater) {
        int nd = cur.days + 1;
        int nw = cur.water + addWater;

        if (nd < dist[nx] || (nd == dist[nx] && nw < water[nx])) {
            dist[nx] = nd;
            water[nx] = nw;
            q.add(new State(nx, nd, nw));
        }
    }
}
