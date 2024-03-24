import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[N-i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> dq = new LinkedList<>();


        for (int i = 1; i <= N; i++) {
            int x = arr[i];
            if (x == 1) {
                dq.addFirst(i);
            } else if (x == 2) {
                int temp = dq.removeFirst();
                dq.addFirst(i);
                dq.addFirst(temp);
            } else {
                dq.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.removeFirst()).append(" ");
        }
        System.out.println(sb);
    }
}