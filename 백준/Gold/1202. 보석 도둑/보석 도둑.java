import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long result = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            while (idx < N && jewels[idx].m <= bags[i]) {
                pq.add(jewels[idx].v);
                idx++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
                // 현재 가방에 넣을 수 있는 모든 보석 중 가장 비싼 보석 넣기
            }
        }
        System.out.println(result);
    }
    private static class Jewel implements Comparable<Jewel> {
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel j) {
            if (this.m == j.m) return j.v - this.v; // 무게가 같다면 가격 내림차순
            return this.m - j.m; // 무게 오름차순
        }
    }
}