import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Highway> highways = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] cost = new int[D+1];
        Arrays.fill(cost, 10001);
        cost[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (e - s <= l) continue;
            if (e > D) continue;
            highways.add(new Highway(s, e, l));
        }
        Collections.sort(highways);

        int pos = 0, idx = 0;
        while (pos < D) {
            if (idx < highways.size()) {
                Highway cur = highways.get(idx);
                if (cur.s == pos) { // 고속도로의 시작점
                    cost[cur.e] = Math.min(cost[pos] + cur.l, cost[cur.e]);
                    idx++; // 같은 위치에서 시작하는 고속도로가 여러개일수도 있으므로 위치는 그대로
                } else {
                    cost[pos + 1] = Math.min(cost[pos + 1], cost[pos] + 1);
                    pos++;
                }
            } else {
                cost[pos + 1] = Math.min(cost[pos + 1], cost[pos] + 1);
                pos++;
            }
        }
        System.out.println(cost[D]);
    }
    private static class Highway implements Comparable<Highway> {
        int s;
        int e;
        int l;

        public Highway(int s, int e, int l) {
            this.s = s;
            this.e = e;
            this.l = l;
        }

        @Override
        public int compareTo(Highway h) {
            if (this.s == h.s) return this.e - h.e;
            return this.s - h.s;
        }
    }
}