import java.util.*;
import java.io.*;

public class Main {
    static class Beer {
        int v, c;
        Beer(int v, int c) {
            this.v = v; this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 마실 맥주 수
        long M = Long.parseLong(st.nextToken());  // 필요한 선호도 합
        int K = Integer.parseInt(st.nextToken()); // 전체 맥주 수

        Beer[] beers = new Beer[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beers[i] = new Beer(v, c);
        }

        Arrays.sort(beers, Comparator.comparingInt(b -> b.c));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long totalLike = 0;
        int answer = -1;

        for (Beer beer : beers) {
            pq.offer(beer.v);
            totalLike += beer.v;

            if (pq.size() > N) {
                totalLike -= pq.poll();
            }

            if (pq.size() == N && totalLike >= M) {
                answer = beer.c;
                break;
            }
        }

        System.out.println(answer);
    }
}
