import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dolls = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dolls);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int size : dolls) {
            if (!pq.isEmpty() && pq.peek() < size) {
                pq.poll();
            }
            pq.offer(size);
        }

        System.out.println(pq.size());
    }
}
