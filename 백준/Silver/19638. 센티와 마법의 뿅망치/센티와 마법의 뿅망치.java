import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            if (h >= H) pq.add(h);
        }

        int cnt = 0;
        while (!pq.isEmpty() && cnt < T) {
            int x = pq.poll() / 2;
            cnt++;

            if (x >= H) {
                pq.add(x);
            } else if (x == 0) {
                pq.add(1);
            }
        }

        if (!pq.isEmpty()) System.out.println("NO\n" + pq.peek());
        else System.out.println("YES\n" + cnt);
    }
}