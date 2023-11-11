import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        int dasom = 0;
        int buy = 0;
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (i == 1) dasom = x;
            else pq.add(x);
        }
        while (true) {
            if (pq.isEmpty() || dasom > pq.peek()) {
                break;
            }

            dasom++;
            buy++;
            int votes = pq.poll();
            pq.add(--votes);
        }

        System.out.println(buy);
    }
}