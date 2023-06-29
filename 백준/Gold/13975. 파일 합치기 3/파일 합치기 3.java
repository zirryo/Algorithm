import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq;

        while (T-- > 0) {
            pq = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long total = 0;
            while (pq.size() >= 2) {
                long x = pq.poll();
                long y = pq.poll();
                total += (x + y);
                pq.add(x + y);
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}