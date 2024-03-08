import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        long result = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            result += a * b;
            pq.add(a + b);
        }

        System.out.println(result);
    }
}