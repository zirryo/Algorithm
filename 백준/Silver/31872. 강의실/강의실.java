import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long res = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            int dist = Math.abs(arr[i] - arr[i-1]);

            if (pq.size() < K) {
                pq.offer(dist);
            } else if (!pq.isEmpty() && dist > pq.peek()) {
                pq.poll();
                pq.offer(dist);
            }

            res += dist;
        }

        for (int x : pq) {
            res -= x;
        }

        System.out.println(res);
    }
}