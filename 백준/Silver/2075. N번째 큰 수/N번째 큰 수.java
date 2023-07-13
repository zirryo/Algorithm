import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (pq.size() < N) pq.add(x);
                else {
                    if (pq.peek() < x) {
                        pq.poll();
                        pq.add(x);
                    }
                }
            }
        }
        System.out.println(pq.poll());
    }
}