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
        int M = Integer.parseInt(st.nextToken());
        boolean flag = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            pq.add(x);
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int y = Integer.parseInt(st.nextToken());
            if (pq.peek() < y) {
                flag = false;
                break;
            } else {
                int present = pq.poll() - y;
                if (present > 0) pq.add(present);
            }
        }

        if (flag) System.out.println(1);
        else System.out.println(0);
    }
}