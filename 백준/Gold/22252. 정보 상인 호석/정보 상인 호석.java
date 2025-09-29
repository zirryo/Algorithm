import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long total = 0;

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (type == 1) {
                int k = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = map.computeIfAbsent(name, x -> new PriorityQueue<>(Comparator.reverseOrder()));
                for (int i = 0; i < k; i++) {
                    int c = Integer.parseInt(st.nextToken());
                    pq.offer(c);
                }
            } else { 
                int b = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> pq = map.get(name);
                if (pq != null) {
                    for (int i = 0; i < b && !pq.isEmpty(); i++) {
                        total += pq.poll();
                    }
                }
            }
        }

        System.out.println(total);
    }
}
