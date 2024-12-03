import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = N-1; i >= 0; i--) {
            if (pq.size() < M) {
                pq.add(arr[i]);
            } else {
                pq.add(arr[i] + pq.poll());
            }
        }

        while (pq.size() > 1) {
            pq.remove();
        }

        System.out.println(pq.poll());
    }
}